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
                    <h2>지점 직원 리스트 <small></small></h2>
                    
                    <div class="clearfix"></div>
                  </div>
                  <div class="x_content">
                    <p class="text-muted font-13 m-b-30">  </p>
                     	전 매장 직원 리스트[직원 코드 클릭 시 상세자료 확인 가능]
                   <!-- 직원코드, 직급명, 아이디, 이름, 생년월일,   -->
                    <table id="datatable" class="table table-striped table-bordered">
                      <thead>
                        <tr>
                          <th>직원코드</th>
                          <th>직급명</th>
                          <th>아이디</th>
                          <th>이름</th>
                          <th>생년월일</th>
                        </tr>
                      </thead><!--branchManagerList  -->
                      <tbody>
                        <c:forEach var="BPList" items="${branchPersonnelList}">
                      	<tr>
                          <td><a href="${pageContext.request.contextPath}/branchPersonnelDetail?branchEmployeeCode=${BPList.branchEmployeeCode}">${BPList.branchEmployeeCode}</a></td> 
                          <td>${BPList.categorySmall}</td>
                          <td>${BPList.branchEmployeeId}</td>
                          <td>${BPList.branchEmployeeName}</td>
                          <td>${BPList.branchEmployeeBirth}</td>
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
           