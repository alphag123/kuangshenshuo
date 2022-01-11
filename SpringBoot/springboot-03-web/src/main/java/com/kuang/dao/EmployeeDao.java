package com.kuang.dao;

import com.kuang.pojo.Department;
import com.kuang.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

//员工Dao
@Repository
public class EmployeeDao {

    //模拟数据库中的数据
    private static Map<Integer, Employee> employees = null;

    //员工有所属的部门
    @Autowired
    private DepartmentDao departmentDao;

    static {
        employees = new HashMap<Integer, Employee>();

        employees.put(1001,new Employee(1001,"AA","A24734673@qq.com",0,new Department(101,"后勤部"),new Date()));
        employees.put(1002,new Employee(1002,"BB","B24734673@qq.com",1,new Department(101,"后勤部"),new Date()));
        employees.put(1003,new Employee(1003,"CC","C24734673@qq.com",0,new Department(101,"后勤部"),new Date()));
        employees.put(1004,new Employee(1004,"DD","D24734673@qq.com",1,new Department(101,"后勤部"),new Date()));
        employees.put(1005,new Employee(1005,"EE","E24734673@qq.com",0,new Department(101,"后勤部"),new Date()));
    }

    //主键自增
    private static Integer ininId = 1006;
    //增加一个员工
    public void save(Employee employee){
        if(employee.getId()==null){
            employee.setId(ininId++);
        }
        employee.setDepartment(departmentDao.getDepartment(employee.getDepartment().getId()));

        employees.put(employee.getId(),employee);
    }

    //查询全部员工信息
    public Collection<Employee> getAll(){
        return employees.values();
    }

    //通过id查询员工
    public Employee getEmployeeById(Integer id){
        return employees.get(id);
    }

    //删除员工通过id
    public void delete(Integer id){
        employees.remove(id);
    }



}
