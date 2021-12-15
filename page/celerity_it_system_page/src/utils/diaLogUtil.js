import {pageUtil} from "@/utils/index";

export default {
    /**
     * 弹出框退出时
     * @param that vue实例对象(this)
     * @param flag 是否更新页面数据
     */
    diaExit(that, flag) {
        if (flag) {
            pageUtil.setPageInData(that);
        }
        that.setDialog({visible: false});
    },
    /**
     * 弹窗打开
     */
    diaOpen(that, dia) {
        that.setDialog({visible: true, title: dia.title, row: dia.row});
    },

    getVal(that, key, ks) {
        if (that.dia) {
            let element = that.dia.row[key];
            if (ks && element) return element[ks];
            return element;
        }
    }
}
