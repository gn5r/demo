package com.gn5r.gn5rapl.demo.entity;

import java.time.LocalDateTime;
import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

/**
 * 親テーブルエンティティクラス
 *
 * @author gn5r
 */
@lombok.Data
@Entity(listener = 親Listener.class)
@Table(name = "親")
public class 親 {

    /** 親ID */
    @Id
    @Column(name = "親ID")
    private Integer parentId;

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