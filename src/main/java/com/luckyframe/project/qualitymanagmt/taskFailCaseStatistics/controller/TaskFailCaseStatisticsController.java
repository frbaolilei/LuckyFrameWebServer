package com.luckyframe.project.qualitymanagmt.taskFailCaseStatistics.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.luckyframe.framework.aspectj.lang.annotation.Log;
import com.luckyframe.framework.aspectj.lang.enums.BusinessType;
import com.luckyframe.project.qualitymanagmt.qaAccident.domain.PieCharts;
import com.luckyframe.project.qualitymanagmt.qaAccident.domain.QaAccident;
import com.luckyframe.project.qualitymanagmt.taskFailCaseStatistics.domain.TaskFailCaseStatistics;
import com.luckyframe.project.qualitymanagmt.taskFailCaseStatistics.service.ITaskFailCaseStatisticsService;
import com.luckyframe.project.system.project.domain.Project;
import com.luckyframe.project.system.project.service.IProjectService;
import com.luckyframe.framework.web.controller.BaseController;
import com.luckyframe.framework.web.page.TableDataInfo;
import com.luckyframe.framework.web.domain.AjaxResult;
import com.luckyframe.common.utils.DateUtils;
import com.luckyframe.common.utils.StringUtils;
import com.luckyframe.common.utils.poi.ExcelUtil;
import com.luckyframe.common.utils.security.ShiroUtils;

/**
 * 失败用例记录分析 信息操作处理
 * 
 * @author luckyframe
 * @date 2020-09-09
 */
@Controller
@RequestMapping("/qualitymanagmt/taskFailCaseStatistics")
public class TaskFailCaseStatisticsController extends BaseController {

	@Autowired
	private IProjectService projectService;

	private String prefix = "qualitymanagmt/taskFailCaseStatistics";

	@Autowired
	private ITaskFailCaseStatisticsService taskFailCaseStatisticsService;

	@RequiresPermissions("qualitymanagmt:taskFailCaseStatistics:view")
	@GetMapping()
	public String taskFailCaseStatistics(HttpServletRequest req, ModelMap mmap) {
		List<Project> projects = projectService.selectProjectAll(0);
		mmap.put("projects", projects);
		if (projects.size() > 0) {
			if (StringUtils.isNotEmpty(ShiroUtils.getProjectId())) {
				mmap.put("defaultProjectId", ShiroUtils.getProjectId());
			}
		}
		return prefix + "/taskFailCaseStatistics";
	}

	/**
	 * 查询失败用例记录分析列表
	 */
	@RequiresPermissions("qualitymanagmt:taskFailCaseStatistics:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(TaskFailCaseStatistics taskFailCaseStatistics) {
		startPage();
		List<TaskFailCaseStatistics> list = taskFailCaseStatisticsService
				.selectTaskFailCaseStatisticsList(taskFailCaseStatistics);
		return getDataTable(list);
	}

	/**
	 * 导出失败用例记录分析列表
	 */
	@RequiresPermissions("qualitymanagmt:taskFailCaseStatistics:export")
	@PostMapping("/export")
	@ResponseBody
	public AjaxResult export(TaskFailCaseStatistics taskFailCaseStatistics) {
		List<TaskFailCaseStatistics> list = taskFailCaseStatisticsService
				.selectTaskFailCaseStatisticsList(taskFailCaseStatistics);
		ExcelUtil<TaskFailCaseStatistics> util = new ExcelUtil<TaskFailCaseStatistics>(
				TaskFailCaseStatistics.class);
		return util.exportExcel(list, "taskFailCaseStatistics");
	}
	
	
	
	/**
	 * 展示失败用例详细信息
	 */
	@GetMapping("/showFailCaseDetail/{id}")
	public String showFailCaseDetail(@PathVariable("id") Integer id, ModelMap mmap)
	{
		TaskFailCaseStatistics taskFailCaseStatistics = taskFailCaseStatisticsService.selectTaskFailCaseStatisticsById(id);
		mmap.put("taskFailCaseStatistics", taskFailCaseStatistics);
	    return prefix + "/detail";
	}

	/**
	 * 新增失败用例记录分析
	 */
	@GetMapping("/add")
	public String add() {
		return prefix + "/add";
	}

	/**
	 * 新增保存失败用例记录分析
	 */
	@RequiresPermissions("qualitymanagmt:taskFailCaseStatistics:add")
	@Log(title = "失败用例记录分析", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(TaskFailCaseStatistics taskFailCaseStatistics) {
		return toAjax(taskFailCaseStatisticsService
				.insertTaskFailCaseStatistics(taskFailCaseStatistics));
	}

	/**
	 * 修改失败用例记录分析
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, ModelMap mmap) {
		List<Project> projects = projectService.selectProjectAll(0);
		mmap.put("projects", projects);
		TaskFailCaseStatistics taskFailCaseStatistics = taskFailCaseStatisticsService
				.selectTaskFailCaseStatisticsById(id);
		mmap.put("taskFailCaseStatistics", taskFailCaseStatistics);
		return prefix + "/edit";
	}

	/**
	 * 修改保存失败用例记录分析
	 */
	@RequiresPermissions("qualitymanagmt:taskFailCaseStatistics:edit")
	@Log(title = "失败用例记录分析", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(TaskFailCaseStatistics taskFailCaseStatistics) {
		return toAjax(taskFailCaseStatisticsService
				.updateTaskFailCaseStatistics(taskFailCaseStatistics));
	}

	/**
	 * 删除失败用例记录分析
	 */
	@RequiresPermissions("qualitymanagmt:taskFailCaseStatistics:remove")
	@Log(title = "失败用例记录分析", businessType = BusinessType.DELETE)
	@PostMapping("/remove")
	@ResponseBody
	public AjaxResult remove(String ids) {
		return toAjax(taskFailCaseStatisticsService
				.deleteTaskFailCaseStatisticsByIds(ids));
	}
	
	/**
	 * 图形展示查询条件
	 * @param mmap 查询对象
	 * @return 返回查询数据
	 * @author Seagull
	 * @date 2019年4月25日
	 */
	@GetMapping("/queryGraph")
	public String queryGraph(ModelMap mmap)
	{
        List<Project> projects=projectService.selectProjectAll(0);
        mmap.put("projects", projects);
        mmap.put("defaultStartDate", DateUtils.getDateByNum(-7));
        mmap.put("defaultEndDate", DateUtils.getDate());
	    return prefix + "/queryGraph";
	}

	/**
	 * 图形展示失败用例
	 * @param request 请求数据
	 * @param mmap 模型MAP
	 * @return 返回mmap数据
	 */
	@GetMapping("/showGraph")
	public String showGraph(HttpServletRequest request,ModelMap mmap)
	{
		String projectId = request.getParameter("projectId");
		String queryStartDate = request.getParameter("queryStartDate");
		String queryEndDate = request.getParameter("queryEndDate");
		String Statistical = request.getParameter("Statistical");
		String dataLatitude = request.getParameter("dataLatitude");
		String projectName="失败用例分析图";
		if(StringUtils.isNotEmpty(projectId)){
	        Project project=projectService.selectProjectById(Integer.parseInt(projectId));
	        projectName = project.getProjectName()+" "+projectName;
		}
		
		mmap.put("projectName", projectName);
		mmap.put("projectId", projectId);
        mmap.put("queryStartDate", queryStartDate);
        mmap.put("queryEndDate", queryEndDate);
        mmap.put("Statistical", Statistical);
        mmap.put("dataLatitude", dataLatitude);
	    return prefix + "/showGraph";
	}

	/**
	 * 图形展示失败用例异步加载数据
	 * @param request 请求
	 * @return 拉取数据
	 */
	@ResponseBody
	@GetMapping("/getGraphData")
	public String getGraphData(HttpServletRequest request)
	{
		String projectId = request.getParameter("projectId");
		String queryStartDate = request.getParameter("queryStartDate");
		String queryEndDate = request.getParameter("queryEndDate");
		String statistical = request.getParameter("Statistical");
		String dataLatitude = request.getParameter("dataLatitude");
		
		TaskFailCaseStatistics taskFailCaseStatistics = new TaskFailCaseStatistics();
		if(StringUtils.isNotEmpty(projectId)){
			taskFailCaseStatistics.setProjectId(Integer.valueOf(projectId));
		}
		Map<String, Object> params = new HashMap<>();
		params.put("beginTime", queryStartDate);
		params.put("endTime", queryEndDate);
		taskFailCaseStatistics.setParams(params);
		
		/*数据纬度*/

		taskFailCaseStatistics.setFailCause("true");
		
		
		List<Map<Object, Object>> list;
		
		/*统计纬度*/
		list=taskFailCaseStatisticsService.selectGroupByFailCaseType(taskFailCaseStatistics);


		PieCharts[] arraydata = new PieCharts[list.size()];
		String[] legendData=new String[list.size()];
		for(int i=0;i<list.size();i++){
			Map<Object, Object> map=list.get(i);
			PieCharts pieData=new PieCharts();
			pieData.setName(map.get("selectName").toString());
			pieData.setValue(Double.parseDouble(map.get("selectValue").toString()));
			arraydata[i] = pieData;
			legendData[i] = map.get("selectName").toString();
		}
		
		String titleText="失败用例分析饼图";
		String titleSubText="所有项目";

		JSONArray jsonArrayData = (JSONArray)JSONArray.toJSON(arraydata);
		JSONArray jsonArraylegendData = (JSONArray)JSONArray.toJSON(legendData);
		return "{\"seriesData\":"+jsonArrayData.toString()+",\"legendData\":"+jsonArraylegendData.toString()+",\"titleText\":\""+titleText+"\",\"titleSubText\":\""+titleSubText+"\"}";
	}

}
