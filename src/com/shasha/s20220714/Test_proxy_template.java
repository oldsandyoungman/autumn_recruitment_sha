package com.shasha.s20220714;

public class Test_proxy_template {

    public static void main(String[] args) {
        Server s = new Server();
        NetWork p = new ProxyServer(s);
        p.browse();
    }

}

interface NetWork{
    public void browse();
}

class Server implements NetWork{
    @Override
    public void browse() {
        System.out.println("真实上网了");
    }
}

class ProxyServer implements NetWork{

    private NetWork n;

    public ProxyServer(NetWork n){
        this.n = n;
    }

    public void check(){
        System.out.println("前期的检查工作");
    }

    @Override
    public void browse() {

        check();

        n.browse();

    }
}
