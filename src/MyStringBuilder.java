import java.util.Stack;

public class MyStringBuilder {
    private StringBuilder sb = new StringBuilder();
    private Stack<Command> commands = new Stack<>();

    public static void main(String[] args) {
        MyStringBuilder b = new MyStringBuilder();
        b.append("Тест номер 1");
        System.out.println(b.sb);
        b.replace(3,6,"fgdfgd");
        b.insert(3,"fdfsfsdf");
        b.append("fdsfdsfsf");
        b.revers();
        b.delete(3, 8);
        System.out.println(b.sb);
        b.undo();
        b.undo();
        b.undo();
        b.undo();
        b.undo();
        System.out.println(b.sb);
    }

    public void append(String str) {
        sb.append(str);
        commands.push(() -> {
            sb.delete(sb.length() - str.length(), sb.length());
        });
    }

    public void delete(int start, int end) {
        String substr = sb.substring(start, end);
        commands.push(() -> {
            sb.insert(start, substr);
        });
        sb.delete(start, end);
    }

    public void revers() {
        sb.reverse();
        commands.push(() -> {
            sb.reverse();
        });
    }

    public void replace(int start, int end, String str) {
        String substr = sb.substring(start, end);
        sb.replace(start, end, str);
        commands.push(() -> {
            sb.delete(start, start + str.length());
            sb.insert(start, substr);
        });
    }

    public void insert(int index, String str) {
        sb.insert(index, str);
        commands.push(() -> {
            sb.delete(index, index + str.length());
        });
    }

    public void undo() {
        Command command = commands.pop();
        if (command != null) {
            command.undo();
        }
    }
}

    interface Command {
        void undo();
    }



