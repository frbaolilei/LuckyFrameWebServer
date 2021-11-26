package com.luckyframe.project.qualitymanagmt.taskFailCaseStatistics.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luckyframe.project.qualitymanagmt.qaAccident.domain.QaAccident;
import com.luckyframe.project.qualitymanagmt.taskFailCaseStatistics.mapper.TaskFailCaseStatisticsMapper;
import com.luckyframe.project.qualitymanagmt.taskFailCaseStatistics.domain.TaskFailCaseStatistics;
import com.luckyframe.project.qualitymanagmt.taskFailCaseStatistics.service.ITaskFailCaseStatisticsService;
import com.luckyframe.common.support.Convert;

/**
 * 失败用例记录分析 服务层实现
 * 
 * @author luckyframe
 * @date 2020-09-09
 */
@Service
public class TaskFailCaseStatisticsServiceImpl implements ITaskFailCaseStatisticsService 
{
	@Autowired
	private TaskFailCaseStatisticsMapper taskFailCaseStatisticsMapper;

	/**
     * 查询失败用例记录分析信息
     * 
     * @param id 失败用例记录分析ID 主键ID
     * @return 失败用例记录分析信息 基础信息
     */
    @Override
	public TaskFailCaseStatistics selectTaskFailCaseStatisticsById(Integer id)
	{
	    return taskFailCaseStatisticsMapper.selectTaskFailCaseStatisticsById(id);
	}
	
	/**
     * 查询失败用例记录分析列表
     * 
     * @param taskFailCaseStatistics 失败用例记录分析信息 基础信息
     * @return 失败用例记录分析集合
     */
	@Override
	public List<TaskFailCaseStatistics> selectTaskFailCaseStatisticsList(TaskFailCaseStatistics taskFailCaseStatistics)
	{
	    return taskFailCaseStatisticsMapper.selectTaskFailCaseStatisticsList(taskFailCaseStatistics);
	}
	
    /**
     * 新增失败用例记录分析
     * 
     * @param taskFailCaseStatistics 失败用例记录分析信息 基础信息
     * @return 结果
     */
	@Override
	public int insertTaskFailCaseStatistics(TaskFailCaseStatistics taskFailCaseStatistics)
	{
	    return taskFailCaseStatisticsMapper.insertTaskFailCaseStatistics(taskFailCaseStatistics);
	}
	
	/**
     * 修改失败用例记录分析
     * 
     * @param taskFailCaseStatistics 失败用例记录分析信息 基础信息
     * @return 结果
     */
	@Override
	public int updateTaskFailCaseStatistics(TaskFailCaseStatistics taskFailCaseStatistics)
	{
	    return taskFailCaseStatisticsMapper.updateTaskFailCaseStatistics(taskFailCaseStatistics);
	}

	/**
     * 删除失败用例记录分析对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTaskFailCaseStatisticsByIds(String ids)
	{
		return taskFailCaseStatisticsMapper.deleteTaskFailCaseStatisticsByIds(Convert.toStrArray(ids));
	}
	
	
	/**
	 * 失败用例根据类型分组统计
	 */
	@Override
	public List<Map<Object, Object>>  selectGroupByFailCaseType(TaskFailCaseStatistics taskFailCaseStatistics)
	{
	    return taskFailCaseStatisticsMapper.selectGroupByFailCaseType(taskFailCaseStatistics);
	}
	
}
