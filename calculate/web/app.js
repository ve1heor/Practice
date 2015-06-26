$(document).ready(function() {

    //Stops the submit request
    $("#myAjaxRequestForm").submit(function(e){
        e.preventDefault();
    });

    //checks for the button click event
    $("#bPlus").click(function(e){

        var value =  $("#value").val();
        var result =  $("#result").val();

        $.ajax({
            type: "POST",
            url: "Result",
            data: {
                "value":value,
                "result":result,
                "plus":"sign"
            },
            dataType: "json",

            success: function( data, textStatus, jqXHR) {
                if(data.success){
                    $("#result").val(data.currvalue);
                    $("#ajaxResponse").html("<table><tr><th>Выражение</th><th>Результат</th><th>Дата</th></tr>" +
                        "<tr><td>"+data.model[0].exp+"</td><td>"+data.model[0].result+"</td><td>"+data.model[0].date+"</td></tr>"+
                        "<tr><td>"+data.model[1].exp+"</td><td>"+data.model[1].result+"</td><td>"+data.model[1].date+"</td></tr>"+
                        "<tr><td>"+data.model[2].exp+"</td><td>"+data.model[2].result+"</td><td>"+data.model[2].date+"</td></tr>"+
                        "<tr><td>"+data.model[3].exp+"</td><td>"+data.model[3].result+"</td><td>"+data.model[3].date+"</td></tr>"+
                        "<tr><td>"+data.model[4].exp+"</td><td>"+data.model[4].result+"</td><td>"+data.model[4].date+"</td></tr>"+
                        "</table>");
                }
                else {
                    $("#ajaxResponse").html("<div><b>Result in Invalid!</b></div>");
                }
            }
        });
    });

    $("#bMinus").click(function(e){

        var value =  $("#value").val();
        var result =  $("#result").val();

        $.ajax({
            type: "POST",
            url: "Result",
            data: {
                "value":value,
                "result":result,
                "minus":"sign"
            },
            dataType: "json",

            success: function( data, textStatus, jqXHR) {
                if(data.success){
                    $("#result").val(data.currvalue);
                    $("#ajaxResponse").html("<table><tr><th>Выражение</th><th>Результат</th><th>Дата</th></tr>" +
                        "<tr><td>"+data.model[0].exp+"</td><td>"+data.model[0].result+"</td><td>"+data.model[0].date+"</td></tr>"+
                        "<tr><td>"+data.model[1].exp+"</td><td>"+data.model[1].result+"</td><td>"+data.model[1].date+"</td></tr>"+
                        "<tr><td>"+data.model[2].exp+"</td><td>"+data.model[2].result+"</td><td>"+data.model[2].date+"</td></tr>"+
                        "<tr><td>"+data.model[3].exp+"</td><td>"+data.model[3].result+"</td><td>"+data.model[3].date+"</td></tr>"+
                        "<tr><td>"+data.model[4].exp+"</td><td>"+data.model[4].result+"</td><td>"+data.model[4].date+"</td></tr>"+
                        "</table>");
                }
                else {
                    $("#ajaxResponse").html("<div><b>Result in Invalid!</b></div>");
                }
            }
        });
    });

    $("#bMultiply").click(function(e){

        var value =  $("#value").val();
        var result =  $("#result").val();

        $.ajax({
            type: "POST",
            url: "Result",
            data: {
                "value":value,
                "result":result,
                "multiply":"sign"
            },
            dataType: "json",

            success: function( data, textStatus, jqXHR) {
                if(data.success){
                    $("#result").val(data.currvalue);
                    $("#ajaxResponse").html("<table><tr><th>Выражение</th><th>Результат</th><th>Дата</th></tr>" +
                        "<tr><td>"+data.model[0].exp+"</td><td>"+data.model[0].result+"</td><td>"+data.model[0].date+"</td></tr>"+
                        "<tr><td>"+data.model[1].exp+"</td><td>"+data.model[1].result+"</td><td>"+data.model[1].date+"</td></tr>"+
                        "<tr><td>"+data.model[2].exp+"</td><td>"+data.model[2].result+"</td><td>"+data.model[2].date+"</td></tr>"+
                        "<tr><td>"+data.model[3].exp+"</td><td>"+data.model[3].result+"</td><td>"+data.model[3].date+"</td></tr>"+
                        "<tr><td>"+data.model[4].exp+"</td><td>"+data.model[4].result+"</td><td>"+data.model[4].date+"</td></tr>"+
                        "</table>");
                }
                else {
                    $("#ajaxResponse").html("<div><b>Result in Invalid!</b></div>");
                }
            }
        });
    });

    $("#bDivide").click(function(e){

        var value =  $("#value").val();
        var result =  $("#result").val();

        $.ajax({
            type: "POST",
            url: "Result",
            data: {
                "value":value,
                "result":result,
                "devide":"sign"
            },
            dataType: "json",

            success: function( data, textStatus, jqXHR) {
                if(data.success){
                    $("#result").val(data.currvalue);
                    $("#ajaxResponse").html("<table><tr><th>Выражение</th><th>Результат</th><th>Дата</th></tr>" +
                        "<tr><td>"+data.model[0].exp+"</td><td>"+data.model[0].result+"</td><td>"+data.model[0].date+"</td></tr>"+
                        "<tr><td>"+data.model[1].exp+"</td><td>"+data.model[1].result+"</td><td>"+data.model[1].date+"</td></tr>"+
                        "<tr><td>"+data.model[2].exp+"</td><td>"+data.model[2].result+"</td><td>"+data.model[2].date+"</td></tr>"+
                        "<tr><td>"+data.model[3].exp+"</td><td>"+data.model[3].result+"</td><td>"+data.model[3].date+"</td></tr>"+
                        "<tr><td>"+data.model[4].exp+"</td><td>"+data.model[4].result+"</td><td>"+data.model[4].date+"</td></tr>"+
                        "</table>");
                }
                else {
                    $("#ajaxResponse").html("<div><b>Result in Invalid!</b></div>");
                }
            }
        });
    });

    $("#bClear").click(function(e){

        var value =  $("#value").val();
        var result =  $("#result").val();

        $.ajax({
            type: "POST",
            url: "Result",
            data: {
                "value":value,
                "result":result,
                "clear":"sign"
            },
            dataType: "json",

            success: function( data, textStatus, jqXHR) {
                if(data.success){
                    $("#result").val(data.currvalue);
                    $("#ajaxResponse").html("<table><tr><th>Выражение</th><th>Результат</th><th>Дата</th></tr>" +
                        "<tr><td>"+data.model[0].exp+"</td><td>"+data.model[0].result+"</td><td>"+data.model[0].date+"</td></tr>"+
                        "<tr><td>"+data.model[1].exp+"</td><td>"+data.model[1].result+"</td><td>"+data.model[1].date+"</td></tr>"+
                        "<tr><td>"+data.model[2].exp+"</td><td>"+data.model[2].result+"</td><td>"+data.model[2].date+"</td></tr>"+
                        "<tr><td>"+data.model[3].exp+"</td><td>"+data.model[3].result+"</td><td>"+data.model[3].date+"</td></tr>"+
                        "<tr><td>"+data.model[4].exp+"</td><td>"+data.model[4].result+"</td><td>"+data.model[4].date+"</td></tr>"+
                        "</table>");
                }
                else {
                    $("#ajaxResponse").html("<div><b>Result in Invalid!</b></div>");
                }
            }
        });
    });

});