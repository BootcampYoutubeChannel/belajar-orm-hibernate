package com.maryanto.dimas.bootcamp.hibernate.query.hql.dao;

import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class CaseWhenConditionDao {

    private Session session;

    public CaseWhenConditionDao(Session session) {
        this.session = session;
    }

    public String simpleCaseWhenExpresion(String employeeId) {
        //language=HQL
        String hql = "select \n" +
                "    case \n" +
                "        when empl.manager is not null then concat('your manager name is ', man.name) \n" +
                "        else 'you don''t have a manager' \n" +
                "    end \n" +
                "from ParentChildEmployeeEntity empl left join ParentChildEmployeeEntity man on (empl.manager = man)\n" +
                "where empl.id = :id";
        Query<String> query = this.session.createQuery(hql, String.class);
        query.setParameter("id", employeeId);
        return query.getSingleResult();
    }


    public String multipleConditionCaseWhenExpresion(String employeeId) {
        //language=HQL
        String hql = "select \n" +
                "     case \n" +
                "        when salary > 10000000 then concat(name, ' gajinya lebih dari Rp. 10jt / bulan') \n" +
                "        when salary between 5000000 and 10000000  then concat(name, ' gajinya diantara Rp. 10jt s/d Rp. 5jt / bulan')\n" +
                "        when salary between 0 and 5000000 then concat(name, ' gajinya dibawah Rp. 5jt / bulan')\n" +
                "        else concat(name, ' kemungkinan karyawan tersebut belum memiliki pekerjaan')\n" +
                "     end\n" +
                "from ParentChildEmployeeEntity \n" +
                "where id = :id";
        Query<String> query = this.session.createQuery(hql, String.class);
        query.setParameter("id", employeeId);
        return query.getSingleResult();
    }

    public String nestedCaseWhenExpresion(String employeeId) {
        //language=HQL
        String hql = "select \n" +
                "    case when empl.manager is not null then \n" +
                "        case when empl.salary > 3000000 then concat(empl.name, ' mendapatan gaji sebulan lebih besar dari Rp.3,000,000.00 dan memiliki atasan bernama ', man.name)\n" +
                "        else concat(empl.name, ' mendapatkan gaji sebulan lebih kecil dari Rp.3,000,000.00 dan memiliki atasan bernama ', man.name)\n" +
                "        end \n" +
                "    else concat(empl.name, ' mendapatkan gaji sebulan sebesar ', empl.salary, ' dan tidak memiliki atasan')\n" +
                "    end \n" +
                "from ParentChildEmployeeEntity empl left join ParentChildEmployeeEntity man on (empl.manager = man)\n" +
                "where empl.id = :id";
        Query<String> query = this.session.createQuery(hql, String.class);
        query.setParameter("id", employeeId);
        return query.getSingleResult();
    }
}
