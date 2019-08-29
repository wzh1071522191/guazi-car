package com.jk.dao;

import com.jk.model.*;
import com.jk.util.ParameUtil;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface Mdao {

    List<Car> querycar(ParameUtil parm);
    Integer sumcount(ParameUtil parm);


    List<CarType> querytye();

     @Delete("delete from t_car where carid=#{id}")
    void deleteUser(String id);


   // @Select(" select count(*) from car_type")
    int sumcount2(ParameUtil parm);

    //@Select("  select *  from  car_type where typename=#{p.typename}  limit #{pageNumber},#{pageSize}")
    List<CarType> querycartype( ParameUtil parm);


    @Update("update t_car set carsxj=2 where carid=#{id}")
    void upx(Integer id);

    int sumcount12(ParameUtil parm);

    List<Car> querycar2(ParameUtil parm);

    @Insert("insert into t_car(carbrandid,cartypeid, carareaid, carcolor, carck, createdate, carstatus,carsxj,carimg) values(#{p.carbrandid},#{p.cartypeid}#{p.carareaid},#{p.carcolor},#{p.carck},now(),#{p.carstatus},1,#{p.carimg})")
    void addcar(@Param("p") Car c);

    @Update("update t_car set carsxj=1 where carid=#{id}")
    void ups(Integer id);

    @Select("select * from t_car where carid=#{id}")
    Car toup(Integer id);
   @Update("update t_car set carbrandid=#{carbrandid},carareaid=#{carareaid},carcolor=#{carcolor},carck=#{carck},carstatus=#{carstatus} where carid=#{carid}")
    void upcar(Car c);
     @Delete("delete from car_type where id=#{id}")
     void deleteUser2(String id);



    int sumcountmc(ParameUtil parm);
    List<Audit> chamaiche(ParameUtil parm);





    Audit querymai(Integer id);


    void addxianxia(Map map);
  @Insert("insert into t_audit(userid,carimg,carname,auditdate,status,varifierid) values(#{p.userid},#{p.carimg},#{p.carname},now(),1,1)")
    void addaudit(@Param("p") Car a);
   @Update("update t_audit set status=2 where id=#{id}")
    void addyes(Integer id);
    @Update("update t_audit set status=3 where id=#{id}")
    void addno(Integer id);

    List<User> queryuser(ParameUtil parm);

    int querykhcon(ParameUtil parm);
    @Update("update t_user set userstatus=2 where userid=#{id}")
    void dsa(Integer id);

    List<User> queryhei(ParameUtil parm);

    int querykhcon2(ParameUtil parm);
    @Update("update t_user set userstatus=1 where userid=#{id}")
    void huifu(Integer id);

 int qu(ParameUtil parm);

 List<jiameng> jm(ParameUtil parm);
@Update("update jiameng set shenhe=2 where id=#{id}")
 void sh(Integer id);

 @Update("update jiameng set shenhe=3 where id=#{id}")
 void sh2(Integer id);

 @Insert("insert into jiameng(username,userphone,shengdq,shidq,sqdate,youxiang,liuyan,shenhe)values(#{username},#{userphone},#{shengdq},#{shidq},now(),#{youxiang},#{liuyan},1)")
 void addjm(jiameng jm);
}
