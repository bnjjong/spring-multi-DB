/*
 * COPYRIGHT (c) ADOP 2020
 * This software is the proprietary of ADOP
 *
 * @author <a href=“mailto:jordan@adop.cc“>jordan</a>
 * @since 2020/09/03
 */
package org.jjong.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * create on 2020/09/03.
 * <p> 클래스 설명 </p>
 * <p> {@link } and {@link }관련 클래스 </p>
 *
 * @author jordan
 * @version 1.0
 * @see
 * @since 지원하는 자바버전 (ex : 5+ 5이상)
 */
@Service
public class SimpleService {
    private final DataSource mainDataSource;

    private final DataSource secondDataSource;

    public SimpleService(@Qualifier("mainDataSource") DataSource mainDataSource, @Qualifier("secondDataSource") DataSource secondDataSource) {
        this.mainDataSource = mainDataSource;
        this.secondDataSource = secondDataSource;
    }


    public void mainDBTest() throws SQLException {
        Connection connection = mainDataSource.getConnection();
        boolean valid = connection.isValid(5);
        if(!valid) {
            throw new SQLException("main connection is not valid");
        }
    }

    public void secondDBTest() throws SQLException {
        Connection connection = secondDataSource.getConnection();
        boolean valid = connection.isValid(5);
        if(!valid) {
            throw new SQLException("second connection is not valid");
        }
    }
}
