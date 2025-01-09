package TicTacToe;

public class Game {
    public static void main(String[] args) {
        System.out.println("Main: Hello and welcome to Tic Tac Toe!");

        int nGames = 10000;
        int[] results = new int[Result.values().length];

        Board board = new Board();
        Renderer renderer = new Renderer();

        System.out.printf("Board created: %d x %d, need %d to win.\n", Board.SIZE, Board.SIZE, Board.WIN_STREAK);
        Player humanPlayer = new HumanPlayer();
        Player randomPlayer = new RandomPlayer();

        String[] strategies = {"smart", "smart1"};
        System.out.printf("Playing %d games with strategies %s (as first) and %s (as second).\n", nGames, strategies[0], strategies[1]);

        //Player player1 = humanPlayer;
        //Player player2 = randomPlayer;
        Player player1 = new Player(strategies[0]);
        Player player2 = new Player(strategies[1]);

        //renderer.renderBoard(board);      // Uncomment to see the initial empty board
        for (int i = 0; i < nGames; i++) {

            Result result = Result.IN_PROGRESS;     // Just to initialize

            // Play moves until the game is over
            for (int n = 0; n < Board.SIZE * Board.SIZE; n++) {
                //renderer.renderBoard(board);
                player1.playTurn(board, Mark.X);    // X
                result = board.checkResult();
                if (result != Result.IN_PROGRESS) {
                    //System.out.printf("\nGame %d over. Strategy: %s.", i + 1, player1.getStrategy());
                    break;
                }
                //renderer.renderBoard(board);
                player2.playTurn(board, Mark.O);
                result = board.checkResult();
                if (result != Result.IN_PROGRESS) {
                    //System.out.printf("\nGame %d over. Strategy: %s.", i + 1, player2.getStrategy());
                    break;
                }

            }

            results[result.ordinal()]++;    // adding the result to the array
            board.clear();
        }
        System.out.println("\nResults:");
        System.out.printf("X (strategy %s) wins: %d\n", player1.getStrategy(), results[Result.X_WINS.ordinal()]);
        System.out.printf("O (strategy %s) wins: %d\n", player2.getStrategy(), results[Result.O_WINS.ordinal()]);
        System.out.printf("Draws: %d\n", results[Result.DRAW.ordinal()]);
        System.out.printf("In progress: %d\n", results[Result.IN_PROGRESS.ordinal()]);
    }
}
/*
הפעם נזדקק לרכיבים נוספים! הנה תיאור של כל הטיפוסים (מסומנים בקו תחתון). טיפוס הוא מונח כללי המתאר מחלקה או ממשק.

תחילה, ניצור את המחלקה Tournament. תפקידה יהיה להריץ את כל הסיבובים/משחקים דרך המחלקה Game. בתורה, תמשיך המחלקה Game להשתמש במחלקה Board שתישאר... ללא שינוי!

מוכנים לגלות את הדבר המגניב ביותר על הפונקציונליות החדשה שאנחנו מוסיפים למשחק? שלפו את האוזניות או מה שיש לכם באוזניים והקשיבו לזה: חוץ מהעובדה שנוציא את main מהקובץ Game.java, גם המחלקה Game לא תשתנה כלל. למעשה, המחלקות Tournament ו־Game שאחראיות להריץ את המשחק יישארו ללא שינוי אפילו כשנוסיף סוגי שחקנים נוספים! "מה זה," אתם זועקים, "מאגיה שחורה!". אבל לא, למעשה זה מדע.

אף־על־פי־כן, יש מקום אחד (ורק אחד) שישתנה בכל פעם שנוסיף סוג שחקן חדש. הסיבה לכך היא שאנחנו אנשים הגונים שמקפידים על 'עקרון האחריות הבודדת' (Single Choice Principle). המקום הזה הוא המחלקה PlayerFactory שאחראית על יצירת השחקנים.

לאחר מכן, ניצור את המחלקות עבור השחקנים CleverPlayer ו־WhateverPlayer. שמה של המחלקה שנקראה בעבר Player ישתנה והיא תיקרא עכשיו HumanPlayer. עבור שלושת סוגי השחקנים האלה, ועבור כל סוג שחקן נוסף, ימומש ממשק חדש: Player.

ולא לשכוח את פונקציית הרינדור החדשה. גם המחלקה Renderer הישנה תשאר ללא שינוי, אבל שמה ישתנה ל־ConsoleRenderer. כמו כן, ימומש ממשק חדש בשם Renderer. המחלקה השנייה שתשתמש בממשק Renderer למעשה לא תצייר כלום על המסך (כך ששחקנים אוטומטיים יוכלו להתחרות זה בזה מבלי שלוחות הממשק ימלאו את שורות הפקודה), אבל היא עדיין צורה של רינדור. היא תקבל את השם VoidRenderer (מכיוון שהיא מרנדרת void, כלומר כלום) והיא תממש את אותו ממשק בדיוק. מפעל נוסף בשם RendererFactory יהיה אחראי על יצירת ממשק ה־Renderer המתאים. זאת דרך פשוטה ואלגנטית להשאיר לעצמנו את האפשרות להוסיף בעתיד למשחק אפשרויות רינדור נוספות, כשכל מה שצריך הוא לשנות את המפעל ולא שום חלק אחר בקוד.

ומבלי להכביר במילים, ככה נראה גרף התלויות החדש:



חי נפשי.

אבל אם תקחו צעד, או חמישה צעדים, לאחור ותסתכלו על התרשים מרחוק, תגלו שהוא דווקא דומה מאוד לתרשים הישן. ההבדל העיקרי הוא שהממשק Player הוחלף בסוגי שחקנים שונים, וכנ"ל ממשק ה־Renderer. במונחים עיצוביים, הוחלפה כל מחלקה במודול שלם. לעת עתה, מודול מתייחס פשוט לקבוצה של טיפוסים שביחד מטפלים בתחום אחריות מסוים.

בנוסף, שני המודולים שלנו גם דומים מאוד זה לזה: שניהם מורכבים מממשק, מימושים מסוימים של הממשק הזה ומפעל שאחראי על יצירת המימושים האלה. אולי גם שמתם לב שאין חצים המחברים בין המודולים. (למה זה עדיף?)

ההבדל הנוסף לעומת הגרף הישן הוא שהוספנו את המחלקה Tournament. המחלקה Tournament תלויה בשני ממשקים (Player ו־Renderer), במפעלים שלהם, ובמחלקה Game.

מספר שורות הקוד החדש של כל הטיפוסים החדשים האלה דומה למספר שורות הקוד של כל התרגיל הקודם. בסך הכול, התרגיל הזה הוא יותר סביב כיף מאשר עבודת תכנות ארוכה ומאתגרת.
 */