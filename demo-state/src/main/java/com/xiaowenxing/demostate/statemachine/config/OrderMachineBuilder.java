package com.xiaowenxing.demostate.statemachine.config;

import com.xiaowenxing.demostate.statemachine.common.Events;
import com.xiaowenxing.demostate.statemachine.common.States;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.config.StateMachineBuilder;
import org.springframework.stereotype.Component;

import java.util.EnumSet;

/**
 * @author XWX
 * @date 2021/6/10 18:31
 * @since 3.6
 **/
@Slf4j
@Component
public class OrderMachineBuilder {

    private final static String MACHINEID = "testMachine";

    public StateMachine<States, Events> build(BeanFactory beanFactory) throws Exception {

        StateMachineBuilder.Builder<States, Events> builder = StateMachineBuilder.builder();

        builder.configureConfiguration()
                .withConfiguration()
                .machineId(MACHINEID)
                .beanFactory(beanFactory);


        builder.configureStates()
                .withStates()
                //定义了初始状态
                .initial(States.UNPAID)
                //指定枚举类States为该状态机的状态定义
                .states(EnumSet.allOf(States.class));

        builder.configureTransitions()
                .withExternal()
                .source(States.UNPAID).target(States.WAITING_FOR_RECEIVE)
                .event(Events.PAY)
                .and()
                .withExternal()
                .source(States.WAITING_FOR_RECEIVE).target(States.DONE)
                .event(Events.RECEIVE);

        return builder.build();
    }


    public static void main(String[] args) {
        test3();
    }

    public static void test() {
        int[] arr = {7, 9, 8, 1, 4, 5};
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int min = arr[j];
                    arr[j] = arr[i];
                    arr[i] = min;
                }
            }
        }
    }

    public static void test2() {
        int[] arr = {7, 9, 8, 1, 4, 5};
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int min = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = min;
                }
            }
        }
    }

    public static void test3() {

        int[][] arr = new int[5][5];

        arr[0][3] = 1;
        arr[1][1] = 2;

        for (int[] ints : arr) {
            for (int anInt : ints) {
                System.out.printf("%d\t", anInt);
            }
            System.out.println();
        }

        int[][] ints = new int[2 + 1][3];
        int index = 0;
        ints[index][0] = 5;
        ints[index][1] = 5;
        ints[index][2] = 2;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i][j] != 0) {
                    ++index;
                    ints[index][0] = i;
                    ints[index][1] = j;
                    ints[index][2] = arr[i][j];
                }
            }
        }

        for (int[] ints1 : ints) {
            for (int anInt : ints1) {
                System.out.printf("%d\t", anInt);
            }
            System.out.println();
        }


        int[][] arr1 = new int[ints[0][0]][ints[0][1]];
        int length = ints.length;
        for (int i = 1; i < ints.length; i++) {
            arr1[ints[i][0]][ints[i][1]] = ints[i][2];
        }

        for (int[] ints1 : arr1) {
            for (int anInt : ints1) {
                System.out.printf("%d\t", anInt);
            }
            System.out.println();
        }

    }

}
