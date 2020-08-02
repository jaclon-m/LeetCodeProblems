package com.jaclon.datestructure.queueandstack;

/**
 * @author jaclon
 * @date 2020/7/31
 */
public class SampleBrowser {

    public static void main(String[] args) {
        SampleBrowser browser = new SampleBrowser();
        browser.open("http://www.baidu.com");
        browser.open("http://news.baidu.com/");
        browser.open("http://news.baidu.com/ent");
        browser.goBack();
        browser.goBack();
        browser.goForward();
        browser.open("http://www.qq.com");
        browser.goForward();
        browser.goBack();
        browser.goForward();
        browser.goBack();
        browser.goBack();
        browser.goBack();
        browser.goBack();
        browser.checkCurrentPage();
    }

    private String currentPage;
    private LinkedListBasedStack backStack;
    private LinkedListBasedStack forwardStack;

    public SampleBrowser(){
        backStack = new LinkedListBasedStack();
        forwardStack = new LinkedListBasedStack();
    }

    public void open(String url){
        if(this.currentPage != null){
            backStack.push(currentPage);
            forwardStack.clear();
        }
        showUrl(url,"open");
    }

    public boolean canGoBack(){
        return backStack.size>0;
    }
    public boolean canGoForward(){
        return forwardStack.size > 0;
    }

    public String goBack(){
        if(canGoBack()){
            forwardStack.push(currentPage);
            String backUrl = backStack.pop();
            showUrl(backUrl,"back");
            return backUrl;
        }
        System.out.println("* Cannot go back, no pages behind.");
        return null;
    }

    public String goForward(){
        if(canGoForward()){
            backStack.push(currentPage);
            String forwardUrl = forwardStack.pop();
            showUrl(forwardUrl,"forward");
            return forwardUrl;
        }
        System.out.println("** Cannot go forward, no pages ahead.");
        return null;
    }

    public void checkCurrentPage() {
        System.out.println("Current page is: " + this.currentPage);
    }

    private void showUrl(String url, String prefix) {
        currentPage = url;
        System.out.println(prefix + "page ==" + url);
    }

    public static class LinkedListBasedStack{
        private int size;
        private Node top;

        static Node createNode(String data, Node next) {
            return new Node(data, next);
        }

        public void clear() {
            this.top = null;
            this.size = 0;
        }

        public void push(String data) {
            Node node = createNode(data, this.top);
            node.next = top;
            top = node;
            this.size++;
        }
        public String pop() {
            Node popNode = this.top;
            if (popNode == null) {
                System.out.println("Stack is empty.");
                return null;
            }
            this.top = popNode.next;
            if (this.size > 0) {
                this.size--;
            }
            return popNode.data;
        }

        public String getTopData() {
            if (this.top == null) {
                return null;
            }
            return this.top.data;
        }

        public int size() {
            return this.size;
        }

    }

    public static class Node {

        private String data;
        private Node next;

        public Node(String data) {
            this(data, null);
        }

        public Node(String data, Node next) {
            this.data = data;
            this.next = next;
        }

        public void setData(String data) {
            this.data = data;
        }

        public String getData() {
            return this.data;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getNext() {
            return this.next;
        }
    }

}
