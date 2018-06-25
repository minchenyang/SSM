<%@ page pageEncoding="UTF-8"%>
<html>
<head>
    <meta charset="utf-8">
    <title>ECharts</title>
    <!-- 引入 echarts.js -->
    <link rel="stylesheet" type="text/css" href="http://cdn.datatables.net/1.10.15/css/jquery.dataTables.css">
    <script type="text/javascript" charset="utf8" src="http://code.jquery.com/jquery-1.10.2.min.js"></script>
    <script type="text/javascript" charset="utf8" src="http://cdn.datatables.net/1.10.15/js/jquery.dataTables.js"></script>
    <script src="echarts.js"></script>
</head>
<body>
<!-- 为ECharts准备一个具备大小（宽高）的Dom -->
<div id="main" style="width: 600px;height:400px;"></div>
<script type="text/javascript">
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('main'));

    function getTreeMap(){
       return  option = {
           series: [{
               type: 'treemap',
               data: [{
                   name: '网页浏览',            // First tree
                   value: 10,
               },{
                   name: '代码编写',            // First tree
                   value: 10,
               },{
                   name: '文档编辑',            // First tree
                   value: 10,
               },{
                   name: '数据处理',            // First tree
                   value: 10,
               },{
                   name: '联想',            // First tree
                   value: 10,
               },{
                   name: '发送邮件',            // First tree
                   value: 10,
               },{
                   name: '产品测试',            // First tree
                   value: 10,
               },{
                   name: '视频会议',            // First tree
                   value: 10,
               }]
           }]
       };

    }
    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(getTreeMap());

    /**================================================================================================================*/
    var data = [
        [
            "Tiger Nixon",
            "System Architect",
            "Edinburgh",
            "5421",
            "2011/04/25",
            "$3,120"
        ],
        [
            "Garrett Winters",
            "Director",
            "Edinburgh",
            "8422",
            "2011/07/25",
            "$5,300"
        ]
    ];



    $(function(){
        //然后 DataTables 这样初始化：
        $('#example').DataTable( {
            data: data
        } );
    });

</script>


<table id="example" class="display">
</table>



</body>
</html>