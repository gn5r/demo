package com.gn5r.gn5rapl.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.gn5r.common.utils.StringUtil;
import com.gn5r.gn5rapl.demo.dto.TopicPathDto;
import com.gn5r.gn5rapl.demo.resource.TopicPathSerchResource;
import com.gn5r.gn5rapl.demo.service.ChildService;
import com.gn5r.spring.boot.common.controller.AbstractRestController;
import com.gn5r.spring.boot.common.exception.RestRuntimeException;
import com.gn5r.spring.boot.common.resource.ErrorResource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = "sample")
@Api(tags = "サンプルコントローラー", description = "サンプル機能のAPIを列挙します")
@CrossOrigin
public class SampleController extends AbstractRestController {

    @Autowired
    private ChildService childService;

    @ApiOperation(value = "Hello World", notes = "GETリクエストを送ると「Hello World!」を返却します")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "サーバー内エラーが発生しました", response = ErrorResource.class, responseContainer = "Set") })
    @GetMapping(value = "hello")
    public ResponseEntity<?> helloWorld() {
        final String msg = "Hello World!";

        return new ResponseEntity<String>(msg, HttpStatus.OK);
    }

    @ApiOperation(value = "親IDから子パンくずリストを取得", notes = "親IDから子パンくずリストを取得します")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "正常に取得できました", response = TopicPathDto.class, responseContainer = "List"),
            @ApiResponse(code = 404, message = "データが見つかりませんでした", response = ErrorResource.class, responseContainer = "Map"),
            @ApiResponse(code = 500, message = "サーバー内エラーが発生しました", response = ErrorResource.class, responseContainer = "Map") })
    @PostMapping(value = "get/topicPath")
    public ResponseEntity<?> getTopicPathByParentId(
            @ApiParam(name = "form", value = "パンくずリスト検索リソース", required = true) @RequestBody(required = true) final TopicPathSerchResource form) {
        List<TopicPathDto> list = new ArrayList<>();

        if (Objects.isNull(form)) {
            throw new RestRuntimeException(HttpStatus.BAD_REQUEST, "検索フォームがnullです");
        }

        if (StringUtil.isEmpty(form.getParentId()) && StringUtil.isEmpty(form.getChildId())) {
            throw new RestRuntimeException(HttpStatus.BAD_REQUEST, "検索フォームがnullです");
        }

        if (StringUtil.isNotEmpty(form.getParentId())) {
            list = childService.getTopicPathByParentId(Integer.parseInt(form.getParentId()));
        } else if (StringUtil.isNotEmpty(form.getChildId())) {
            list = childService.getTopicPathByChildId(Integer.parseInt(form.getChildId()));
        }

        return new ResponseEntity<List<TopicPathDto>>(list, HttpStatus.OK);
    }

    @ApiOperation(value = "", notes = "")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "正常に取得できました", response = TopicPathDto.class, responseContainer = "List"),
            @ApiResponse(code = 404, message = "データが見つかりませんでした", response = ErrorResource.class, responseContainer = "Map"),
            @ApiResponse(code = 500, message = "サーバー内エラーが発生しました", response = ErrorResource.class, responseContainer = "Map") })
    @PostMapping(value = "get/topicPath/all")
    public ResponseEntity<?> getTopicPathByForm(
            @ApiParam(name = "form", value = "パンくずリスト検索リソース", required = true) @RequestBody(required = true) final TopicPathSerchResource form) {
        List<TopicPathDto> list = new ArrayList<>();

        if (Objects.isNull(form)) {
            throw new RestRuntimeException(HttpStatus.BAD_REQUEST, "検索フォームがnullです");
        }

        if (StringUtil.isEmpty(form.getParentId()) && StringUtil.isEmpty(form.getChildId())) {
            throw new RestRuntimeException(HttpStatus.BAD_REQUEST, "検索フォームがnullです");
        }

        if (StringUtil.isNotEmpty(form.getParentId())) {
            list = childService.getAllChildList(Integer.parseInt(form.getParentId()));
        } else if (StringUtil.isNotEmpty(form.getChildId())) {
            list = childService.getAllChildListByChildId(Integer.parseInt(form.getChildId()));
        }

        return new ResponseEntity<List<TopicPathDto>>(list, HttpStatus.OK);
    }
}