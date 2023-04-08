<%@ page import="com.javaee.bitlab.db.models.Task" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-aFq/bzH65dt+w6FI2ooMVUpc+21e0SRygnTpmBvdBgSdnuTN7QbdgL+OapgHtvPp"
          crossorigin="anonymous">
    <title>Task details</title>
    <style>
        body {
            padding: 0;
        }

        .navbar {
            display: flex;
            padding: 20px;
            justify-content: flex-start;
            background-color: #0a2b84;
            color: #fff;
        }

        a {
            text-decoration: none;
            color: white;
        }
    </style>
</head>
<body>

<div>
    <div class="navbar">
        <div style="width: 20%">
            <strong>TASK MANAGER</strong>
        </div>
        <div style="width: 80%">
            <a href="/">All tasks</a>
        </div>
    </div>
    <%
        Task task = (Task) request.getAttribute("task");
    %>
    <div style="display: flex; justify-content: center">
            <div style="width: 60%; margin-top: 5px" >
                    <form action="/details" method="post">
                        <div class="form-group" style=" margin-top: 20px">
                            <label> Name:
                                <input style="width: 600px" class="form-control" name="name" type="text" value="<%out.println(task.getName());%>">
                            </label>
                        </div>
                        <div  class="form-group" style=" margin-top: 20px">
                            <label> Description:
                                <textarea class="form-control" name="description" id="" cols="75" rows="4"><%out.println(task.getDescription());%></textarea>
                            </label>
                        </div>
                        <div  class="form-group" style=" margin-top: 20px">
                            <label> Deadline:
                                <input style="width: 600px" class="form-control" name="deadline" type="date" value="<% out.print(task.getDeadline()); %>">
                            </label>
                        </div>
                        <div  class="form-group" style=" margin-top: 20px ;margin-bottom: 20px">
                            <label> Is done:
                                <select name="isDone" class="form-control" style="width: 600px" >
                                    <option value="false">no</option>
                                    <option <% if (task.isDone()){%>selected<%}%> value="true">yes</option>
                                </select>
                            </label>
                        </div>
                        <input type="hidden" name="id" value="<% out.print(task.getId()); %>">
                        <button class="btn btn-success">save</button>
                    </form>
                <form action="/delete" method="post">
                    <input type="hidden" name="id" value="<% out.print(task.getId()); %>">
                    <button class="btn btn-danger">delete</button>
                </form>
            </div>
    </div>
</div>
</body>
</html>
