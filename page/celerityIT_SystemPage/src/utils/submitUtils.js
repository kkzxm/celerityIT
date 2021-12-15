import API from "@/api/api_user";
import {checkRes} from "@/api";
import {diaLogUtil} from "@/utils/index";

export default {
    result: {},
    /**
     *
     * @param that
     * @param params
     * @param flag1
     * @param flag2
     * flag1与flag2共同组成flag:
     * flag 有效值以及 boolean的true:修改
     *             值无效以及 boolean的false:添加
     */
    onSubmit(that, params, flag1, flag2) {
        let flag = flag1;
        if (flag2) {
            flag += flag2;
        }
        //flag有值更改,无值新增
        switch (true) {
            case flag:
            case flag > 0:
            case flag && typeof flag !== "boolean" && flag.trim() !== '':
                API[that.$route.name].update(params).then((res) => this.do(that, res));
                break;
            case !flag:
                API[that.$route.name].add(params).then((res) => this.do(that, res));
                break;
            default:
                break;
        }
    },
    resultVal(that, flag) {
        return (that.dia.title) + (flag ? '成功' : '失败');
    },
    success(that) {
        return {
            /*成功时更新列表,并关闭dialog,并且存储操作成功*/
            message: this.resultVal(that, true), fun: () => {
                diaLogUtil.diaExit(that, true);
            }
        }
    },
    error(that) {
        return {
            /*失败时只是关闭dialog*/
            message: this.resultVal(that, false), fun: () => {
                diaLogUtil.diaExit(that);
            }
        }
    },
    do(that, res) {
        this.result = res;
        return checkRes(res, this.success(that), this.error(that));
    }
}
