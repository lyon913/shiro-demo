/**
 * Created by Lyon on 2016/10/21.
 */
/**
 *收件材料编辑模块
 * @param ywh 业务号
 * @param djsx 登记事项
 * @constructor
 */
function CfdjSearchDialog(ywh,selectedCbk) {
    _register('CfdjSearchDialog',this);
    this.ywh = ywh;
    var me = this;


    //模态对话框
    this.dialog = $("<div>").dialog({
        title: '查封信息查询',
        width: 800,
        height: 400,
        closed: true,
        cache: false,
        modal: true,
        href: 'cfSearch.jsp?ywh=' + ywh
    });
    //显示对话框
    this.open = function () {
        me.dialog.dialog('open');
    };

    //关闭对话框
    this.close = function () {
        me.dialog.dialog('close');
    };

    this.selected = function(rows){
        me.rows = rows;
        me.close();

        selectedCbk(rows);
    }
    return this;
}