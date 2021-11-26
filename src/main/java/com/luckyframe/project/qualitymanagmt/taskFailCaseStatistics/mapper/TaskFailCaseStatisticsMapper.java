package com.luckyframe.project.qualitymanagmt.taskFailCaseStatistics.mapper;

import com.luckyframe.project.qualitymanagmt.qaAccident.domain.QaAccident;
import com.luckyframe.project.qualitymanagmt.taskFailCaseStatistics.domain.TaskFailCaseStatistics;

import java.util.List;	
import java.util.Map;

/**
 * 失败用例记录分析 数据层
 * 
 * @author luckyframe
 * @date 2020-09-09
 */
public interface TaskFailCaseStatisticsMapper 
{
	/**
     * 查询失败用例记录分析信息
     * 
     * @param taskCaseId 失败用例记录分析ID 主键ID
     * @return 失败用例记录分析信息
     */
	public TaskFailCaseStatistics selectTaskFailCaseStatisticsById(Integer taskCaseId);
	
	/**
     * 查询失败用例记录分析列表
     * 
     * @param taskFailCaseStatistics 失败用例记录分析信息 基本信息
     * @return 失败用例记录分析集合
     */
	public List<TaskFailCaseStatistics> selectTaskFailCaseStatisticsList(TaskFailCaseStatistics taskFailCaseStatistics);
	
	/**
     * 新增失败用例记录分析
     * 
     * @param taskFailCaseStatistics 失败用例记录分析信息 基本信息
     * @return 结果
     */
	public int insertTaskFailCaseStatistics(TaskFailCaseStatistics taskFailCaseStatistics);
	
	/**
     * 修改失败用例记录分析
     * 
     * @param taskFailCaseStatistics 失败用例记录分析信息 基本信息
     * @return 结果
     */
	public int updateTaskFailCaseStatistics(TaskFailCaseStatistics taskFailCaseStatistics);
	
	/**
     * 删除失败用例记录分析
     * 
     * @param taskCaseId 失败用例记录分析ID 主键ID
     * @return 结果
     */
	public int deleteTaskFailCaseStatisticsById(Integer taskCaseId);
	
	/**
     * 批量删除失败用例记录分析
     * 
     * @param taskCaseIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteTaskFailCaseStatisticsByIds(String[] taskCaseIds);
	
	
	/**
	 * 用例根据类型分组统计
	 * @param taskFailCaseStatistics 对象
	 * @return 返回LIST
	 * @author lilei
	 * @date 2019年8月1日
	 */
	List<Map<Object,Object>> selectGroupByFailCaseType(TaskFailCaseStatistics taskFailCaseStatistics);
	
}