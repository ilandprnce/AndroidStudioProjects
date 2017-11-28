package edu.clarkson.mercere.mathfour;

/**
 * Created by Eric on 11/25/2017.
 */

import java.util.Random;

import static java.util.Arrays.sort;

public class MathMaker {

    protected String eqn;
    private Random rand;
    protected int ans;
    protected int[] options;


    public MathMaker() {
        this.rand = new Random();
        this.eqn = genEqn();
        this.options = makeOptions();
        this.ans = getAns();
    }


    public int genNum() {
        int num = rand.nextInt(10)+1;

        return num;
    }

    public String genOp() {
        int num = rand.nextInt(3)+1; // make 3 to 4 to enable div.
        String op = null;

        while(num < 1 && num < 4 ) {
            num = rand.nextInt(3)+1;
        }

        if(num==1) {
            op = "+";
        }else if(num==2) {
            op = "-";
        }else if(num==3) {
            op = "*";
        }else if(num==4) { // I disabled Division. It's impractical with this app.
            op = "/";
        }

        return op;
    }

    public String genEqn() {
        int num1 = genNum();
        int num2 = genNum();
        String op = genOp();

        //System.out.println(num1+"operator" +num2);

        eqn = String.valueOf(num1)+ String.valueOf(op)+String.valueOf(num2);

        return eqn;
    }

    public int getAns(){
        int answer = 0;

    try{
        answer = ParserII.DO(eqn);
    } catch (Exception e) {
        // TODO Auto-generated catch block
        System.out.println(e);
    }

        return answer;
    }

    public int genOptions(int ans) {
        int high = ans + 4;
        int low = ans - 4;
        int opt = rand.nextInt(high-low)+low;
        return opt;
    }


    public int[] makeOptions(){

        int[] options = new int[4]; //
        int[] temp = new int[4];
        int generated;

        temp[0] = getAns();
        for(int i=1;i<4;i++){
            generated = genOptions(getAns());

            while(generated == temp[0] ){  // just makes sure there is only one solution. duplicate answers still possible.
                generated = genOptions(getAns());
            }


            temp[i] = generated;


        }

        sort(temp);
        options=temp;

        return options;
    }






}

