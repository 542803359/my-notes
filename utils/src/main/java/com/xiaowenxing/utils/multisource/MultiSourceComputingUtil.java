package com.xiaowenxing.utils.multisource;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * 多源计算工具类
 *
 * @author xiaowx
 * @date 2021/12/31 14:57
 **/
public class MultiSourceComputingUtil {
    private MultiSourceComputingUtil() {
    }


    private static final Integer MAX = 100;

    /**
     * 数据比对
     *
     * @param num1 对比值1
     * @param num2 对比值2
     * @return 返回结果值 1:num1 gt num2  0:num1 eq num2 -1:num1 lt num2
     */
    public static Integer contrast(int num1, int num2) {
        return Integer.compare(num1, num2);
    }


    /**
     * 多源比率分页
     *
     * @param param 计算分页参数 请求参数
     * @return 返回比率分页参数
     */
    public static RatioPagination multiSourceRatioPagination(RatioPaginationParam param) {

        int priorityLimitStart = -1;
        int prioritySize = -1;
        int nonPriorityLimitStart = -1;
        int nonPrioritySize = -1;
        //优先每页展示率算出当前页展示size
        int priorityPageSize = Math.toIntExact((long) param.getRatio() * param.getPageSize() / 100);
        //计算优先总页数
        int priorityPageCount = (param.getPriorityCount() + priorityPageSize - 1) / priorityPageSize;

        if (param.getRatio() == MAX) {

            /*如果优先都取优先队列数据,优先队列取完再取非优先*/

            if (param.getCurrent() == priorityPageCount) {
                priorityLimitStart = (param.getCurrent() - 1) * param.getPageSize();
                prioritySize = param.getPriorityCount() - priorityLimitStart;
                nonPriorityLimitStart = 0;
                nonPrioritySize = param.getPageSize() - prioritySize;

            } else if (param.getCurrent() < priorityPageCount) {

                priorityLimitStart = (param.getCurrent() - 1) * param.getPageSize();
                prioritySize = param.getPageSize();

            } else if (param.getCurrent() > priorityPageCount) {

                int start = (param.getCurrent() - 1) * param.getPageSize();
                if (start < param.getAllCount()) {
                    nonPriorityLimitStart = start - param.getPriorityCount();
                    if (param.getCurrent() * param.getPageSize() > param.getAllCount()) {
                        nonPrioritySize = param.getAllCount() - start;
                    } else {
                        nonPrioritySize = param.getPageSize();
                    }
                }
            }
            return new RatioPagination(priorityLimitStart, prioritySize, nonPriorityLimitStart, nonPrioritySize);

        } else {

            /*按比率取优先与非优先*/

            //计算非优先总条数
            int nonPriorityCount = param.getAllCount() - param.getPriorityCount();
            //计算非优先每页展示
            int nonPriorityPageSize = param.getPageSize() - priorityPageSize;
            //计算非优先总页数
            int nonPriorityPageCount = (nonPriorityCount + nonPriorityPageSize - 1) / nonPriorityPageSize;
            int contrastResult = contrast(priorityPageCount, nonPriorityPageCount);

            switch (contrastResult) {
                //优先页小于非优先页
                case -1:
                    //当前页小于优先页总页数，可进行正常比率查询
                    if (param.getCurrent() < priorityPageCount) {
                        //优先每页长度 * 到上一页页书 = 当前页开始index
                        priorityLimitStart = priorityPageSize * (param.getCurrent() - 1);
                        prioritySize = priorityPageSize;

                        nonPriorityLimitStart = nonPriorityPageSize * (param.getCurrent() - 1);
                        nonPrioritySize = nonPriorityPageSize;
                        return new RatioPagination(priorityLimitStart, prioritySize, nonPriorityLimitStart, nonPrioritySize);
                    }
                    //当前页大于优先页总页数，代表优先数据已全部展示完毕，当前页不考虑比率，全部取非优先数据
                    if (param.getCurrent() > priorityPageCount) {
                        //优先页pageSize * 优先页pageCount - 优先页Count = 优先页末页缺失条数
                        int priorityLastPageDefect = priorityPageSize * priorityPageCount - param.getPriorityCount();
                        //优先总页*非优先每页展示量 + 优先页缺失条数 = 优先页结束时非优先已展示数据总量
                        int priorityEndNonPriorityCount = priorityPageCount * nonPriorityPageSize + priorityLastPageDefect;
                        //优先分页结束后到当前页上一页非优先的展示总数
                        int afterEndCount = (param.getCurrent() - 1 - priorityPageCount) * param.getPageSize();
                        nonPriorityLimitStart = priorityEndNonPriorityCount + afterEndCount;
                        nonPrioritySize = param.getPageSize();
                        if (nonPriorityLimitStart >= (param.getAllCount() - param.getPriorityCount())) {
                            nonPriorityLimitStart = -1;
                            nonPrioritySize = -1;
                        }
                        if (nonPriorityLimitStart + nonPrioritySize > (param.getAllCount() - param.getPriorityCount())) {
                            nonPrioritySize = (param.getAllCount() - param.getPriorityCount()) - nonPriorityLimitStart;
                        }
                        return new RatioPagination(priorityLimitStart, prioritySize, nonPriorityLimitStart, nonPrioritySize);
                    }
                    //当前页等于优先页总数 则代表当前页为优先页末页，需要考虑优先数据是否满足比率要求数量，若不满足则用非优先数据补齐
                    if (param.getCurrent() == priorityPageCount) {
                        //优先页pageSize * 优先页pageCount - 优先页Count = 优先页末页缺失条数
                        int priorityLastPageDefect = priorityPageSize * priorityPageCount - param.getPriorityCount();
                        priorityLimitStart = priorityPageSize * (param.getCurrent() - 1);
                        prioritySize = priorityPageSize - priorityLastPageDefect;

                        nonPriorityLimitStart = nonPriorityPageSize * (param.getCurrent() - 1);
                        nonPrioritySize = nonPriorityPageSize + priorityLastPageDefect;
                        return new RatioPagination(priorityLimitStart, prioritySize, nonPriorityLimitStart, nonPrioritySize);
                    }
                    throw new RuntimeException("分页参数计算错误");

                case 0:
                    //优先页等于非优先页 正常返回
                    priorityLimitStart = priorityPageSize * (param.getCurrent() - 1);
                    prioritySize = priorityPageSize;

                    nonPriorityLimitStart = nonPriorityPageSize * (param.getCurrent() - 1);
                    nonPrioritySize = nonPriorityPageSize;
                    return new RatioPagination(priorityLimitStart, prioritySize, nonPriorityLimitStart, nonPrioritySize);
                case 1:
                    //优先页大于非优先页 则通过非优先页进行分页参数计算
                    // 当前页小于非优先页 正常按比率返回
                    if (param.getCurrent() < nonPriorityPageCount) {
                        //优先每页长度 * 到上一页页书 = 当前页开始index
                        priorityLimitStart = priorityPageSize * (param.getCurrent() - 1);
                        prioritySize = priorityPageSize;

                        nonPriorityLimitStart = nonPriorityPageSize * (param.getCurrent() - 1);
                        nonPrioritySize = nonPriorityPageSize;
                        return new RatioPagination(priorityLimitStart, prioritySize, nonPriorityLimitStart, nonPrioritySize);
                    }
                    //若当前页大于非优先页 则当前页完全返回优先数据 不考虑比率
                    if (param.getCurrent() > nonPriorityPageCount) {
                        //非优先页pageSize * 非优先页pageCount - 非优先页Count = 非优先页末页缺失条数
                        int nonPriorityLastPageDefect = nonPriorityPageSize * nonPriorityPageCount - nonPriorityCount;
                        //非优先总页*优先每页展示量 + 非优先页缺失条数 = 非优先页结束时优先已展示数据总量
                        int nonPriorityEndPriorityCount = nonPriorityPageCount * priorityPageSize + nonPriorityLastPageDefect;
                        //非优先分页结束后到当前页上一页优先的展示总数
                        int afterEndCount = (param.getCurrent() - 1 - nonPriorityPageCount) * param.getPageSize();
                        priorityLimitStart = nonPriorityEndPriorityCount + afterEndCount;
                        prioritySize = param.getPageSize();
                        if (priorityLimitStart >= param.getPriorityCount()) {
                            priorityLimitStart = -1;
                            prioritySize = -1;
                        }
                        if (priorityLimitStart + prioritySize > param.getPriorityCount()) {
                            prioritySize = param.getPriorityCount() - priorityLimitStart;
                        }
                        return new RatioPagination(priorityLimitStart, prioritySize, nonPriorityLimitStart, nonPrioritySize);
                    }
                    //若当前页等于非优先页，则考虑非优先数据是否满足比率数量，不满足则用优先商品数据补齐
                    if (param.getCurrent() == nonPriorityPageCount) {
                        //优先页pageSize * 优先页pageCount - 优先页Count = 优先页末页缺失条数
                        int nonPriorityLastPageDefect = nonPriorityPageSize * nonPriorityPageCount - nonPriorityCount;
                        priorityLimitStart = priorityPageSize * (param.getCurrent() - 1);
                        prioritySize = priorityPageSize + nonPriorityLastPageDefect;

                        nonPriorityLimitStart = nonPriorityPageSize * (param.getCurrent() - 1);
                        nonPrioritySize = nonPriorityPageSize - nonPriorityLastPageDefect;
                        return new RatioPagination(priorityLimitStart, prioritySize, nonPriorityLimitStart, nonPrioritySize);
                    }
                    throw new RuntimeException("分页参数计算错误");
                default:
                    throw new RuntimeException("分页参数计算错误");
            }
        }
    }


    /**
     * 测试内部类
     */
    static class Demo {
        private static final List<Integer> one = new ArrayList<>();
        private static final List<Integer> two = new ArrayList<>();

        static {
            for (int i = 0; i < 17; i++) {
                one.add(i);
            }
            for (int i = 0; i < 26; i++) {
                two.add(i);
            }
        }

        public static void main(String[] args) {
            for (int i = 1; i < 10; i++) {
                RatioPaginationParam param = new RatioPaginationParam();
                param.setAllCount(one.size() + two.size());
                param.setPriorityCount(one.size());
                param.setRatio(100);
                param.setCurrent(i);
                param.setPageSize(10);
                RatioPagination ratioPagination = MultiSourceComputingUtil.multiSourceRatioPagination(param);
                System.out.println(JSONObject.toJSONString(ratioPagination));
            }
        }
    }
}
