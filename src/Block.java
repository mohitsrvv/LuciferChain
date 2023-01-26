import javax.xml.crypto.Data;
import java.util.Date;

public class Block {
    public String hash;
    public String previousHash;
    private String data;       // data will be a simple message
    private long timeStamp;     // as number of milliseconds
    private int nonce;

    // constructor
    public Block(String data, String previousHash){
        this.data = data;
        this.previousHash = previousHash;
        this.timeStamp = new Date().getTime();
        this.hash = calculateHash();
    }
    public String calculateHash(){
        String calculateHash = StringUtil.applySha256(
                previousHash +
                        Long.toString(timeStamp) +
                        data
        );
        return calculateHash;
    }

    public void mineBlock(int difficulty){
        String target = new String(new char[difficulty]).replace('\0', '0'); //create a sting with diff 0
        while(!hash.substring(0,difficulty).equals(target)){
            nonce++;
            hash = calculateHash();
        }
        System.out.println("Block Mined!!! : " + hash);
    }
}






















