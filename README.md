# ✅ TodoList-App

### 🔮 기능
 - item 추가
 - item 수정
 - item 삭제
 - item 조회
       : item 리스트를 출력, item은 할일 내용과 완료상태를 표시 해야함
 - item 완료 상태 변경 (toggle)
 - Todo item은 간단히 내용과 완료 상태를 표시
 - Todo item 들은 csv file 형태로 저장
 - GUI는 따로 구현하지는 않으며 standard input으로 command 입력받아 기능 조작


### 🔮 설계
 - Command를 처리하는 Class
 - CSV File 또는 DB를 이용할 수 있는 각자의 Interface
 - CSV는 동작부까지 구현, DB는 미정
 
### 🔮 예시
command id         command
       ------------------------------------------
          1             create an item
          2             modify an item
          3             delete an item (or all)
          4             show items
          5             toggle status of an item
           

       command : 1
       todo task: buy milk

      ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

       command : 1
       todo task: book flight

      ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

       command : 4

       index            todo                status
       --------------------------------------------
         1             buy milk               n
         2             book flight            n


      ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

       command : 3
       remove index : 1


      ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

       command : 4

       index            todo                status
       --------------------------------------------
         1             book flight            n

      ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

       command : 5
       index number : 1


      ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

       command : 4

       index            todo                status
       --------------------------------------------
         1             book flight            y
         
