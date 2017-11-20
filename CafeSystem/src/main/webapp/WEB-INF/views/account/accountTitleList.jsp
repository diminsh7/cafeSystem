<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
  <div class="right_col" role="main">
          <div class="">
            <div class="page-title">
              <div class="title_left">
                <h3>계정과목관리</h3>
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
                      	계정과목 리스트
                    </p>
                    <table id="datatable" class="table table-striped table-bordered">
                      <thead>
                        <tr>
                          <th>계정과목코드	</th>
                          <th>계정과목명</th>
                          <th>상세내용</th>
                          <th>수정</th>
                          <th>삭제</th>
                        </tr>
                      </thead><!--branchManagerList  -->
                      <tbody>
                      <c:forEach var="accountTitle" items="${accountlist}">
                     	<tr>
                          <td>${accountTitle.accountTitleCode}</td>
                          <td>${accountTitle.accountTitleName}</td>
                          <td>${accountTitle.accountTitleContent}</td>
                          <td><a href ="${pageContext.request.contextPath}/accountTitleUpdateForm?accountTitleCode=${accountTitle.accountTitleCode}">수정</a></td>
                          <td><a href =""></a></td>
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
           