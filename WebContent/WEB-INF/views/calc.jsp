<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<html>
  <head>
    <title>Calculator</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/style.css" />" >
  </head>
  <body>
    <div class="calcForm">
      <h1>Enter an Equation</h1>


      <form method="POST" name="calcForm">
        <textarea name="firstNumber" cols="5" rows="1">1</textarea><br/>
        <select name = "operator" size="4">
  			<option value="plus">Plus</option>
  			<option value="minus">Minus</option>
  			<option value="times">Times</option>
  			<option value="dividedBy">Divided By</option>
		</select> <br/>
        <textarea name="secondNumber" cols="5" rows="1">2</textarea><br/>
        <input type="submit" value="Calculate" />
      </form>
    </div>
    <div class="listTitle">
      <h1>Recent Calculations</h1>
      <ul class="calcList">
        <c:forEach items="${calcList}" var="calculation" >
          <li id="calculation_<c:out value="calculation.id"/>">
            <div class="firstNum"><c:out value="${calculation.firstNumber}" /></div>
            <div>
              <span class="operation"><c:out value="${calculation.operator}" /></span>
              <span class="secondNumber">(<c:out value="${calculation.secondNumber}" /></span>
              <span class="output"><c:out value="${calculation.answer}" />)</span>
            </div>
          </li>
        </c:forEach>
      </ul>

    </div>
  </body>
</html>