package com.gn5r.gn5rapl.demo.entity;

import java.time.LocalDateTime;
import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

/**
 * ユーザーテーブルエンティティクラス
 *
 * @author gn5r
 */
@lombok.Data
@Entity(listener = ユーザーListener.class)
@Table(name = "ユーザー")
public class ユーザー {

    /** ユーザーID */
    @Id
    @Column(name = "ユーザーID")
    private String userId;

    /** 子ID */
    @Column(name = "ユーザー名")
    private String userName;

    /** 登録日 */
    @Column(name = "登録日")
    private LocalDateTime registDate;

    /** 更新日 */
    @Column(name = "更新日")
    private LocalDateTime updateDate;
}