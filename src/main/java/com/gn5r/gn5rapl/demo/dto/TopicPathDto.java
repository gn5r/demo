package com.gn5r.gn5rapl.demo.dto;

import java.time.LocalDateTime;
import java.util.List;

@lombok.Data
public class TopicPathDto {
    
    /** 親ID */
    private Integer parentId;

    /** 子ID */
    private Integer childId;

    /** 上位子ID */
    private Integer upperChildId;

    /** 名前 */
    private String name;

    /** 登録日 */
    private LocalDateTime registDate;

    /** 登録者ID */
    private String registerId;

    /** 登録者名 */
    private String register;

    /** 更新日 */
    private LocalDateTime updateDate;

    /** 更新者ID */
    private String updaterId;

    /** 更新者名 */
    private String updater;

    /** 孫リスト */
    private List<TopicPathDto> childList;
}