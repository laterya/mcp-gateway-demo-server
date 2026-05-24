package cn.laterya.demo.controller;

import cn.laterya.demo.model.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/")
@Tag(name = "员工管理服务", description = "公司员工信息查询接口")
public class EmployeeController {

    private static final List<Employee> EMPLOYEES = List.of(
            new Employee(1L, "张三", "技术部", "高级Java工程师", 28000, "北京", "2022-03-15", "zhangsan@example.com"),
            new Employee(2L, "李四", "技术部", "前端工程师", 22000, "北京", "2023-01-10", "lisi@example.com"),
            new Employee(3L, "王五", "产品部", "产品经理", 25000, "上海", "2021-07-20", "wangwu@example.com"),
            new Employee(4L, "赵六", "市场部", "市场总监", 32000, "深圳", "2020-05-08", "zhaoliu@example.com"),
            new Employee(5L, "孙七", "技术部", "测试工程师", 20000, "北京", "2023-06-01", "sunqi@example.com"),
            new Employee(6L, "周八", "产品部", "产品助理", 15000, "上海", "2024-02-14", "zhouba@example.com"),
            new Employee(7L, "吴九", "市场部", "运营专员", 18000, "深圳", "2023-09-01", "wujiu@example.com"),
            new Employee(8L, "郑十", "技术部", "架构师", 38000, "北京", "2019-11-20", "zhengshi@example.com")
    );

    private static final List<Department> DEPARTMENTS = List.of(
            new Department(1L, "技术部", "郑十", 4),
            new Department(2L, "产品部", "王五", 2),
            new Department(3L, "市场部", "赵六", 2)
    );

    @PostMapping("employee/query")
    @Operation(summary = "查询员工列表", description = "根据城市、部门、关键词筛选员工信息")
    public EmployeeQueryResponse queryEmployees(@RequestBody EmployeeQueryRequest request) {
        log.info("查询员工 city:{} department:{} keyword:{}", request.getCity(), request.getDepartmentName(), request.getKeyword());

        List<Employee> result = EMPLOYEES.stream()
                .filter(e -> request.getCity() == null || request.getCity().isEmpty() || e.getCity().equals(request.getCity()))
                .filter(e -> request.getDepartmentName() == null || request.getDepartmentName().isEmpty() || e.getDepartment().equals(request.getDepartmentName()))
                .filter(e -> request.getKeyword() == null || request.getKeyword().isEmpty()
                        || e.getName().contains(request.getKeyword())
                        || e.getPosition().contains(request.getKeyword()))
                .collect(Collectors.toList());

        return new EmployeeQueryResponse(result, result.size());
    }

    @GetMapping("employee/{id}")
    @Operation(summary = "查询员工详情", description = "根据员工ID查询详细信息")
    public Employee getEmployeeDetail(
            @Parameter(description = "员工ID", required = true) @PathVariable("id") Long id) {
        log.info("查询员工详情 id:{}", id);
        return EMPLOYEES.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @GetMapping("department/list")
    @Operation(summary = "查询部门列表", description = "获取公司部门信息，可按城市筛选")
    public List<Department> listDepartments(
            @Parameter(description = "城市（可选，按城市统计部门人数）") @RequestParam(value = "city", required = false) String city) {
        log.info("查询部门列表 city:{}", city);
        if (city != null && !city.isEmpty()) {
            long count = EMPLOYEES.stream().filter(e -> e.getCity().equals(city)).count();
            return DEPARTMENTS.stream().map(d -> new Department(d.getId(), d.getName(), d.getManager(),
                    (int) EMPLOYEES.stream().filter(e -> e.getDepartment().equals(d.getName()) && e.getCity().equals(city)).count()
            )).collect(Collectors.toList());
        }
        return DEPARTMENTS;
    }
}
