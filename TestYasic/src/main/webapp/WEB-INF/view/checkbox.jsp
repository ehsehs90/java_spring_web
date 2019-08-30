<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<script
   src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<script language="javascript">
   function saveClose() {
      self.close();
   }

   var log = console.log;
   
   function checkboxCreate() {
      f.action = "./checkbox.do";
      f.method = "post";
      f.submit();
      self.close();
   }

   function userList() {
      self.close();
   }
</script>
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<style type="text/css">
body {
   font-size: 75%;
   font-family: "Segoe UI", "Helvetica Neue", Helvetica, Arial, sans-serif;
}

label {
   font-weight: normal;
   float: left;
   margin-right: .5em;
   font-size: 1.1em;
}

select {
   margin-right: 1em;
   float: left;
}
</style>
<title>Uri</title>
</head>
<body onload="window.resizeTo(400,550)">
<form name="f">
   <h1>카테고리를 선택해 주세요.</h1>
   <li>1. 용도를 선택해주세요.</li>
   <input type="radio" name="why">식사
   <input type="radio" name="why">운동
   <input type="radio" name="why">영화
   <input type="radio" name="why">기타
   <input type="radio" name="why">상관없음
   <br>
   <br>
   <br>
   <li>2. 시간을 선택해주세요.</li>
   <br>
   <select id="start" name="stime" onfocus="babo()" onchange="mungchung()">
   <option value="--" selected>--</option>
      <script>
         var i = 1;
         function babo() {
            for (; i <= 24; i++) {
               $("#start").append(
                     $("<option val="+i+">" + i + "</option>"));
               //document.write('<option value=' + i + '>' + i + '</option>');
               log(i);
                  
            }
         }
         function mungchung() {
            var start = parseInt($("#start").val());
            log(start);
            $("#end").empty();
            for (var j = start; j <= start + 12; j++) {
               $("#end").append(
                     $("<option val="+j+">" + j % 24 + "</option>"));
               log(j);
            }
         }
         var k = 0;
         var l = 0;
               function babot() {
                  for (; k <= 59; k=k+5) {
                     $("#startt").append(
                           $("<option val="+k+">" + k + "</option>"));
                     //document.write('<option value=' + i + '>' + i + '</option>');
                     log(k);
                  }

               }
               function mungchungt() {
                  var startt = parseInt($("#startt").val());
                  log(startt);
                  $("#endt").empty();
                  var a = parseInt($("#start").val());
                  var b = parseInt($("#end").val());
                  
                  if(a==b){
                     for (var h = startt + 5; h <= 59; h=h+5) {
                        $("#endt").append(
                              $("<option val="+h+">" + h + "</option>"));
                        log(h);
                     }
                  }
                  else{
                     for (; l <= 59; l=l+5) {
                        $("#endt").append(
                              $("<option val="+l+">" + l + "</option>"));
                        log(h);
                     }

                  }
                     
               }
   </script>
   </select>
   <label>시</label>
   <select id="startt" name="etime" onfocus="babot()" onchange="mungchungt()">
   <option value="--" selected>--</option>
   </select>
   <label>분부터 ~</label>
   <select id="end">
   <option value="--" selected>--</option>
   </select>
   <label>시</label>
   <select id="endt">
   <option value="--" selected>--</option>
   </select>
   <label>분까지</label>
   <br>
   <br>


   <br>
   <br>
   <br>
   <br>
   <li>3. 장소를 선택해주세요.</li>
   <textarea name="content" cols="40" rows="1"></textarea>
   <br>
   <br>
   <br>
   <li>4. 인원수를 선택해주세요.</li>
   <input type="radio" name="pnum">2
   <input type="radio" name="pnum">3
   <input type="radio" name="pnum">4
   <input type="radio" name="pnum">5
   <input type="radio" name="pnum">기타
   <input type="radio" name="pnum">상관없음
   <br>
   <br>
   <br>
   <!-- <li>5. 불 색깔을 선택해주세요.</li>
   <input style="color: green;" type="radio" name="color">초록
   <input type="radio" name="color" style="color: blue;">파랑
   <input type="radio" name="color" style="color: yellow;">노랑
   <br>
   <br>
   <br> -->
   <li>5. 상태 메시지를 적어주세요.</li>
   <textarea name="msg" cols="40" rows="1"></textarea>
   <br>
   <input type="button" value="확 인" onClick="checkboxCreate()"> &nbsp;
   <input type="button" value="닫 기" onClick="userList()">
   </form>
</body>
</html>