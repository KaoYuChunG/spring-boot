package com.kao.cache.cache.service;

import com.kao.cache.cache.bean.Employee;
import com.kao.cache.cache.mapper.IEmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;

//@CacheConfig(cacheNames="emp") -> 此註解可以代替所有的　value="emp"，及公共配置。
//@CacheConfig(cacheNames="emp", cacheManager = "redisCacheManager")
@Service
public class EmployeeService {

    @Autowired
    IEmployeeMapper employeeMapper;

//  cacheNames/value : 指定緩存組件名子
//  key        : 緩存數據使用，用於指定，默認是參數值　＞　key="#id"
//  keyGenerator : key生成器，可以自己指定key的生成器的組件id
//  *  key and keyGenerator 選一
//  cacheManager: 指定緩存管理器　（cacheResolver 有一樣的功能）
//　condition　：　指定條件　　＞　condition = "#id>0"
//  unless : 否定緩存，當unless指定的條件為true，返回值就不會被緩存，也可用於判斷　＞　unless="#result == null"
//  sync　：　異步
//  @Cacheable(cacheNames = {"emp"}, keyGenerator="myKeyGenerator")//自定義
    @Cacheable(cacheNames = {"emp"}, cacheManager = "redisCacheManager") //進行一次性緩存
    public Employee getEmp(Integer id){
        Employee emp = employeeMapper.getEmpById(id);
        return emp;
    }

//  調用方法又更新緩存數據
//  先調用目標方法，再將目標方法的結果緩存起來　
//  用　key = "#employee.id"　來達到同步更新->數據庫和緩存。
//  重點，@Cacheable　和　@CachePut　的key要是同一個
    @CachePut(value="emp", key = "#employee.id")
    public Employee updateEmp(Employee employee) {
        employeeMapper.updateEmp(employee);
        return employee;
    }

    //透過key來指定要清除的數據
    //beforeInvocation　緩存清除是否在方法之前執行
    //allEntries 刪所有緩存數據，allEntries = true
    //＊　allEntries 和　key　選一使用
    @CacheEvict(value="emp",  key ="#id")
    public void deleteEmp(Integer id) {

    }

    //緩存方式比較複雜時使用，是綜合前三個的
    @Caching(
       cacheable = {
          @Cacheable(value = "emp", key = "#lastName")
       },
       put = {
          @CachePut(value = "emp", key = "#result.id"),
          @CachePut(value = "emp", key = "#result.email")
       }
    )
    public Employee getEmpByLastName(String lastName) {
        return employeeMapper.getEmpByLastName(lastName);
    }

}
