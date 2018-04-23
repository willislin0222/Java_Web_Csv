package com.csv.model;

import java.sql.Connection;
import java.util.List;

public interface EMP_interface {
     public List<EmpVO> getAll(Connection conn);
     
}
