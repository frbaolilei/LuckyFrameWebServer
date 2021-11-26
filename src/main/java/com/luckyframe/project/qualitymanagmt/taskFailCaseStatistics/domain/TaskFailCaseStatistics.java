package com.luckyframe.project.qualitymanagmt.taskFailCaseStatistics.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.luckyframe.framework.web.domain.BaseEntity;

import java.util.Date;

/**
 * 失败用例记录分析表 task_fail_case_statistics
 * 
 * @author luckyframe
 * @date 2020-09-09
 */
public class TaskFailCaseStatistics extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** ID */
	private Integer id;
	/** 任务ID */
	private Integer taskId;
	/** 用例执行ID */
	private Integer taskCaseId;
	/** 项目ID */
	private Integer projectId;
	/** 用例ID */
	private Integer caseId;
	/** 用例标识 */
	private String caseSign;
	/** 用例名称 */
	private String caseName;
	/** 失败原因 0bug 1数据 2需求变更 3环境 4脚本 5其它 6未处理 */
	private String failCause;
	/** 用例结束时间 */
	private Date finishTime;
	/** 创建者 */
	private String createBy;
	/** 创建时间 */
	private Date createTime;
	/** 更新者 */
	private String updateBy;
	/** 更新时间 */
	private Date updateTime;
	/** 失败说明 */
	private String failRemark;
	/** 关联bug链接 */
	private String bugLink;
	/** 是否删除 */
	private Boolean isDeleted;

	public void setId(Integer id) 
	{
		this.id = id;
	}

	public Integer getId() 
	{
		return id;
	}
	
	public void setTaskId(Integer taskId) 
	{
		this.taskId = taskId;
	}
	
	public Integer getTaskId() 
	{
		return taskId;
	}
	
	public void setTaskCaseId(Integer taskCaseId) 
	{
		this.taskCaseId = taskCaseId;
	}
	
	public Integer getTaskCaseId() 
	{
		return taskCaseId;
	}
	
	public void setProjectId(Integer projectId) 
	{
		this.projectId = projectId;
	}

	public Integer getProjectId() 
	{
		return projectId;
	}
	public void setCaseId(Integer caseId) 
	{
		this.caseId = caseId;
	}

	public Integer getCaseId() 
	{
		return caseId;
	}
	public void setCaseSign(String caseSign) 
	{
		this.caseSign = caseSign;
	}

	public String getCaseSign() 
	{
		return caseSign;
	}
	public void setCaseName(String caseName) 
	{
		this.caseName = caseName;
	}

	public String getCaseName() 
	{
		return caseName;
	}
	public void setFailCause(String failCause) 
	{
		this.failCause = failCause;
	}

	public String getFailCause() 
	{
		return failCause;
	}
	public void setFinishTime(Date finishTime) 
	{
		this.finishTime = finishTime;
	}

	public Date getFinishTime() 
	{
		return finishTime;
	}
	public void setCreateBy(String createBy) 
	{
		this.createBy = createBy;
	}

	public String getCreateBy() 
	{
		return createBy;
	}
	public void setCreateTime(Date createTime) 
	{
		this.createTime = createTime;
	}

	public Date getCreateTime() 
	{
		return createTime;
	}
	public void setUpdateBy(String updateBy) 
	{
		this.updateBy = updateBy;
	}

	public String getUpdateBy() 
	{
		return updateBy;
	}
	public void setUpdateTime(Date updateTime) 
	{
		this.updateTime = updateTime;
	}

	public Date getUpdateTime() 
	{
		return updateTime;
	}
	public void setFailRemark(String failRemark) 
	{
		this.failRemark = failRemark;
	}

	public String getFailRemark() 
	{
		return failRemark;
	}
	public void setBugLink(String bugLink) 
	{
		this.bugLink = bugLink;
	}

	public String getBugLink() 
	{
		return bugLink;
	}
	public void setIsDeleted(Boolean isDeleted) 
	{
		this.isDeleted = isDeleted;
	}

	public Boolean getIsDeleted() 
	{
		return isDeleted;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("taskId", getTaskId())
            .append("taskCaseId", getTaskCaseId())
            .append("projectId", getProjectId())
            .append("caseId", getCaseId())
            .append("caseSign", getCaseSign())
            .append("caseName", getCaseName())
            .append("failCause", getFailCause())
            .append("finishTime", getFinishTime())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("failRemark", getFailRemark())
            .append("bugLink", getBugLink())
            .append("isDeleted", getIsDeleted())
            .toString();
    }
}
