package com.gn5r.gn5rapl.demo.entity;

import java.time.LocalDateTime;
import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

/**
 * 子テーブルエンティティクラス
 *
 * @author gn5r
 */
@lombok.Data
@Entity(listener = 子Listener.class)
@Table(name = "子")
public class 子 {

    /** 親ID */
    @Column(name = "親ID")
    private Integer parentId;

    /** 子ID */
    @Id
    @Column(name = "子ID")
    private Integer childId;

    /** 上位子ID */
    @Column(name = "上位子ID")
    private Integer upperChildId;

    /** 名前 */
    @Column(name = "名前")
    private String name;

    /** 登録日 */
    @Column(name = "登録日")
    private LocalDateTime registDate;

    /** 登録者ID */
    @Column(name = "登録者ID")
    private String registerId;

    /** 更新日 */
    @Column(name = "更新日")
    private LocalDateTime updateDate;

    /** 更新者ID */
    @Column(name = "更新者ID")
    private String updaterId;
}