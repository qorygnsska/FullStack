<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>새 게시글 작성하기</title>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
    <div class="container mt-5">
        <div class="row justify-content-center">
            <div class="col-md-8">
                <div class="card">
                    <div class="card-header text-center">
                        <h2>새글 작성하기</h2>
                    </div>
                    <div class="card-body">
                        <form method="post" 
                        	  action="_03boardWritePro.jsp">
                            <div class="form-group">
                                <label for="writer">작성자</label>
                                <input type="text" 
                                	   class="form-control" 
                                	   id="writer" name="writer" required>
                            </div>
                            <div class="form-group">
                                <label for="subject">제목</label>
                                <input type="text" class="form-control" id="subject" name="subject" required>
                            </div>
                            <div class="form-group">
                                <label for="email">이메일</label>
                                <input type="email" class="form-control" id="email" name="email" required>
                            </div>
                            <div class="form-group">
                                <label for="password">비밀번호</label>
                                <input type="password" class="form-control" id="password" name="password" required>
                            </div>
                            <div class="form-group">
                                <label for="content">내용</label>
                                <textarea class="form-control" id="content" name="content" rows="10" required></textarea>
                            </div>
                            <div class="text-center">
                                <button type="submit" class="btn btn-primary">등록하기</button>
                                <button type="reset" class="btn btn-secondary">다시 작성하기</button>
                                <button type="button" class="btn btn-secondary" onclick="window.location.href='_04boardList.jsp'">목록으로</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
