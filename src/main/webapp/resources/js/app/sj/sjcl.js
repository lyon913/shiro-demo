/**
 *收件材料编辑模块
 * @param ywh 业务号
 * @param djsx 登记事项
 * @constructor
 */
function SjclDialog(ywh, djsx) {

    this.ywh = ywh;
    this.djsx = djsx;
    this.dataUrl = 'sj/data.json';
    this.autoCompleteUrl = 'sj/autoComplete.json';
    this.templateHtmlUrl = 'sjcl.jsp';

    this.editIndex = undefined;
    var me = this;


    //模态对话框
    this.dialog = $("<div>").dialog({
        title: '收件材料',
        width: 800,
        height: 400,
        closed: true,
        cache: false,
        modal: true
    });
    this.dialog.append()

    //datagrid组件
    $.ajax({
        url: me.templateHtmlUrl,
        type: 'get'
    }).done(function (html) {
        //模板读取成功
        me.templateHtml = html;
        var grid = $(me.templateHtml);
        //编译easyui组件
        $.parser.parse(grid);
        me.dialog.append(grid);

        //初始化datagrid
        me.grid = $("#_grid_sjcl").datagrid({
            fit: true,
            rownumbers: true,
            singleSelect: true,
            url: me.dataUrl,
            method: 'post',
            queryParams: {
                ywh: me.ywh,
                djsx: me.djsx
            },
            columns: [[
                {
                    field: 'name',
                    title: '材料名称',
                    width: 250,
                    editor: {
                        type: 'combobox',
                        options: {
                            valueField: 'name',
                            textField: 'name',
                            mode: 'remote',
                            url: me.autoCompleteUrl,
                            method: 'post',
                            required: true
                        }
                    }
                },
                {
                    field: 'type',
                    title: '类型',
                    width: 100,
                    editor: {
                        type: 'combobox',
                        options: {
                            valueField: 'name',
                            textField: 'name',
                            data: [{
                                name: '原件'
                            }, {
                                name: '原件复印'
                            }, {
                                name: '原件正本'
                            }, {
                                name: '原件副本'
                            }],
                            required: true
                        }
                    }
                },
                {
                    field: 'number',
                    title: '份数',
                    width: 100,
                    editor: {
                        type: 'numberbox'
                    }
                },
                {
                    field: 'pageNumber',
                    title: '页数',
                    width: 100,
                    editor: {
                        type: 'numberbox'
                    }
                }
            ]],
            onClickCell: function (index, field, value) {
                if (me.editIndex != index) {
                    if (me.endEditing()) {
                        me.editIndex = index;
                        me.grid.datagrid('selectRow', index).datagrid('beginEdit', index);
                        var ed = me.grid.datagrid('getEditor', {index: index, field: field});
                        if (ed) {
                            ($(ed.target).data('textbox') ? $(ed.target).textbox('textbox') : $(ed.target)).focus();
                        }

                    } else {
                        setTimeout(function () {
                            me.grid.datagrid('selectRow', me.editIndex);
                        }, 0);
                    }
                }
            }
        });
    });

    //初始化模板选择combobox
    this.tb = $("#_tb_sjcl");

    var cb = $('<div id="_cb_temp"></div>').appendTo(this.tb);
    cb.combobox({
        valueField: 'name',
        textField: 'name',
        data:[{
            name:'存量房买卖'
        },{
            name:'继承'
        }],
        required: true
    });

    this.endEditing = function () {
        if (me.editIndex == undefined) {
            return true
        }
        if (me.grid.datagrid('validateRow', me.editIndex)) {
            me.grid.datagrid('endEdit', me.editIndex);
            me.editIndex = undefined;
            return true;
        } else {
            return false;
        }
    };
    this.del = function (fid) {
        if (fid) {
            alert('执行后台删除');
        }
        alert('前端删除');
    };

    //显示对话框
    this.open = function () {
        me.dialog.dialog('open');
    };

    //关闭对话框
    this.close = function () {
        me.dialog.dialog('close');
    };

    //加载材料模板
    this.loadSjclTemplate = function (djsx) {
        me.djsx = djsx;
        me.grid.datagrid('reload', {
            ywh: me.ywh,
            djsx: me.djsx
        });
    };

    return this;
}