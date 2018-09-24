public class N014 {
    public int max(int length){
        if (length < 2){
            return 0;
        }
        if (length == 2){
            return 1;
        }
        if (length == 3){
            return 2;
        }
        //尽可能多减长度为3的绳子段
        int timesOf3 = length / 3;
        //如果剪完长度为3的绳子段后留下了1米，则少减1段，留下4米
        //剪成2段2米的，因为2*2 > 3*1
        if (length - timesOf3 * 3 == 1){
            timesOf3 -= 1;
        }

        int timesOf2 = (length - timesOf3 * 3) / 2;
        return (int)(Math.pow(3, timesOf3) * (int)(Math.pow(2, timesOf2)));
    }
}
