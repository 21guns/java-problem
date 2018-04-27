package com.guns21.hikari.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author jliu
 */
@Data
@Entity
@Table(name = "TB_LOAN")
public class LoanDO {

    @Id
    private String id;

    private String title;

    private String summary;

    private String categoryId;

    private Date publishTime;
    /**
     * 额度-最小
     */
    private Integer quotaMin;

    /**
     * 额度-最大
     */
    private Integer quotaMax;

    /**
     * 期限-最小
     */
    private Integer termMin;

    /**
     * 期限-最大
     */
    private Integer termMax;

    /**
     * 利率
     */
    private BigDecimal interestAmount;

    /**
     * 标签
     */
    @Column(columnDefinition = "json")
    private String tags;

    /**
     * 图标
     */
    private String cover;

    /**
     * 注册url
     */
    private String url;

    /**
     * 申请条件
     */
    private String applyConditions;

    /**
     * 申请人数
     */
    private Integer applyCount;

    /**
     * 审核说明
     */
    private String auditInstructions;

    /**
     * 新手指导
     */
    private String guide;

    /**
     *
     */

}
