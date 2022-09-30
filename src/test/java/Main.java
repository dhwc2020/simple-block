import com.dhwc.pojo.bo.BlockBO;

/**
 * @author dhwc
 * @create 2022-09-30 16:32
 */
public class Main {
    public static void main(String[] args) {
        BlockBO blockBO = new BlockBO("0", "这是第一个区块");
        blockBO.mineBlock(5);

        BlockBO blockBO1 = new BlockBO(blockBO.getHash(), "这是第二个区块");
        blockBO1.mineBlock(5);

        BlockBO blockBO2 = new BlockBO(blockBO1.getHash(), "这是第三个区块");
        blockBO2.mineBlock(5);

        System.out.println(blockBO.getData() + ": " + blockBO.getHash());
        System.out.println(blockBO1.getData() + ": " + blockBO1.getHash());
        System.out.println(blockBO2.getData() + ": " + blockBO2.getHash());
    }
}
