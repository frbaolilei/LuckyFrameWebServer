package com.luckyframe.project.qualitymanagmt.taskFailCaseStatistics.service;

import com.luckyframe.project.qualitymanagmt.qaAccident.domain.QaAccident;
import com.luckyframe.project.qualitymanagmt.taskFailCaseStatistics.domain.TaskFailCaseStatistics;

import java.util.List;
import java.util.Map;

/**
 * 失败用例记录分析 服务层
 * 
 * @author luckyframe
 * @date 2020-09-09
 */
public interface ITaskFailCaseStatisticsService 
{
	/**
     * 查询失败用例记录分析信息
     * 
     * @param id 失败用例记录分析ID 主键ID
     * @return 失败用例记录分析信息
     */
	public TaskFailCaseStatistics selectTaskFailCaseStatisticsById(Integer id);
	
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
     * 删除失败用例记录分析信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTaskFailCaseStatisticsByIds(String ids);
	
	/**
     * 事故根据类型分组统计
     * 
     * @param TaskFailCaseStatistics 生产事故登记信息
     * @return 生产事故登记集合
     */
	List<Map<Object, Object>>  selectGroupByFailCaseType(TaskFailCaseStatistics taskFailCaseStatistics);
	
}
