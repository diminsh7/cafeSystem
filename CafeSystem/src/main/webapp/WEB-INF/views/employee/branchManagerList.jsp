<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
  <div class="right_col" role="main">
          <div class="">
            <div class="page-title">
              <div class="title_left">
                <h3>지점인사관리</h3>
              </div>
            </div>

            <div class="clearfix"></div>

            <div class="row">
              <div class="col-md-12 col-sm-12 col-xs-12">
                <div class="x_panel">
                  <div class="x_title">
                    <h2>지점장 리스트 <small></small></h2>
                    
                    <div class="clearfix"></div>
                  </div>
                  <div class="x_content">
                    <p class="text-muted font-13 m-b-30">
                      	전 매장 지점장 리스트
                    </p>
                    <table id="datatable" class="table table-striped table-bordered">
                      <thead>
                        <tr>
                          <th>직원코드</th>
                          <th>아이디</th>
                          <th>이름</th>
                          <th>생년월일</th>
                          <th>점포명</th>
                        </tr>
                      </thead><!--branchManagerList  -->
                      <tbody>
                        <c:forEach var="BMList" items="${branchManagerList}">
                      	<tr>
                          <td><a href="${pageContext.request.contextPath}/branchManagerDetail?branchEmployeeCode=${BMList.branchEmployeeCode}">${BMList.branchEmployeeCode}</a></td> 
                          <td>${BMList.branchEmployeeId}</td>
                          <td>${BMList.branchEmployeeName}</td>
                          <td>${BMList.branchEmployeeBirth}</td>
						  <td>${BMList.shopName}</td>
                        </tr>
                      </c:forEach>
                                                            
                      </tbody>
                    </table>
                  </div>
                </div>
              </div>
             </div>
            </div>
           </div>
           