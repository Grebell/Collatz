package com.company;

import java.lang.String;

public class Collatz {
    public static void main(String[] args) {
        String input = null;
        int Length = 0;
        long Height = 1;
        long Rise = 0;
        long Fall = 0;
        int PosTransitions = 0;
        int NegTransitions = 0;
        int TotLength = 0;
        long TotHeight = 0;
        long TotRise = 0;
        long TotFall = 0;
        int TotTransitions = 0;
        int TotPosTransitions = 0;
        int TotNegTransitions = 0;
        int MaxLength = 0;
        long MaxHeight = 0;
        long MaxRise = 0;
        long MaxFall = 0;
        int MaxTransitions = 0;
        int MaxPosTransitions = 0;
        int MaxNegTransitions = 0;
        StringBuilder whatMaxLength = new StringBuilder(String.valueOf(0));
        StringBuilder whatMaxHeight = new StringBuilder(String.valueOf(0));
        StringBuilder whatMaxRise = new StringBuilder(String.valueOf(0));
        StringBuilder whatMaxFall = new StringBuilder(String.valueOf(0));
        StringBuilder whatMaxTransitions = new StringBuilder(String.valueOf(0));
        StringBuilder whatMaxPosTransitions = new StringBuilder(String.valueOf(0));
        StringBuilder whatMaxNegTransitions = new StringBuilder(String.valueOf(0));
        double AvgLength;
        double AvgHeight;
        double AvgRise;
        double AvgFall;
        double AvgTransitions;
        double AvgPosTransitions;
        double AvgNegTransitions;


        System.out.println();//space
        if (args.length > 0) { //makes input if necessary
            input = args[0];
        }
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////// no arg
        if (args.length == 0) {
            input = "1:100000000";
        }
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// range
        if (input.contains(":")) {
            String[] numbs;
            numbs = input.split(":");
            int numOne = Integer.parseInt(numbs[0]);
            int numTwo = Integer.parseInt(numbs[1]);
            if (numOne < 1 || numTwo > 100000000) {
                System.out.println("out of range");
                System.exit(7);
            }
            int i;

            for (i = numOne; i <= numTwo; i++) {
                /*
                if (i % 1000000 == 0) {
                    System.out.println((i / 1000000) + "/" + numTwo / 1000000); ////////////small little optional counter
                }
                */
                Length = 0;
                Height = 1;
                Rise = 1;
                Fall = 1;
                long co = i;

                long n = co;
                //System.out.print(co);
                long fall = 0;
                int preTrans = 2;
                PosTransitions = 0;
                NegTransitions = 0;
                if (co == 1) {
                    Length = 3;
                    Height = 4;
                    Rise = 0;
                    Fall = 3;
                }

                while (co != 1) {

                    ////////////////////////////////////////////length
                    Length += 1;
                    ////////////////////////////////////////////height
                    if (co > Height) {
                        Height = co;
                    }
                    long preNum = co;
                    co = collatz(co);/////////////////////////////////////////collatz
                    /////////////////////////////////////////////////////Transitions
                    if (co > n && preTrans == 0) {
                        PosTransitions++;
                        preTrans = 1;
                    }
                    else {
                        if (co < n && preTrans == 1) {
                            NegTransitions++;
                            preTrans = 0;
                        }
                        else {
                            if (co > n) {
                                preTrans = 1;
                            }
                            else {
                                if (co < n) {
                                    preTrans = 0;
                                }
                            }
                        }

                    }
                    /////////////////////////////////////////////rise
                    long rise = co - preNum;
                    if (rise > Rise) {
                        Rise = rise;
                    }
                    /////////////////////////////////////////////fall
                    if (preNum > co) {
                        fall = fall + (preNum - co);
                    }
                    else {
                        if (fall > Fall) {
                            Fall = fall;
                        }
                        fall = 0;
                    }
                    if (fall > Fall) {
                        Fall = fall;

                    }

                    //System.out.print("->"+co);
                    if (co < 0) {
                        System.exit(666);
                    }

                }

/// find totals

                TotLength = TotLength + Length;
                TotHeight = TotHeight + Height;
                TotRise = TotRise + Rise;
                TotFall = TotFall + Fall;

                TotTransitions = TotTransitions + PosTransitions + NegTransitions;
                TotPosTransitions = TotPosTransitions + PosTransitions;
                TotNegTransitions = TotNegTransitions + NegTransitions;

                /*
                find maxes
                 */
                if (Height >= MaxHeight) {
                    //if = add to list of maxes
                    if (Height == MaxHeight) {
                        //append (,x)
                        whatMaxHeight.append(",").append(i);
                    }
                    //if > eradicate old list start anew
                    if (Height > MaxHeight) {
                        whatMaxHeight = new StringBuilder(String.valueOf(i));
                    }
                    MaxHeight = Height;
                }
                if (Length >= MaxLength) {
                    if (Length == MaxLength) {
                        //append (,x)
                        whatMaxLength.append(",").append(i);
                    }
                    //if > eradicate old list start anew
                    if (Length > MaxLength) {
                        whatMaxLength = new StringBuilder(String.valueOf(i));
                    }
                    MaxLength = Length;
                }
                if (Rise >= MaxRise) {
                    if (Rise == MaxRise) {
                        //append (,x)
                        whatMaxRise.append(",").append(i);
                    }
                    //if > eradicate old list start anew
                    if (Rise > MaxRise) {
                        whatMaxRise = new StringBuilder(String.valueOf(i));
                    }
                    MaxRise = Rise;
                }
                if (Fall >= MaxFall) {
                    if (Fall == MaxFall) {
                        //append (,x)
                        whatMaxFall.append(",").append(i);
                    }
                    //if > eradicate old list start anew
                    if (Fall > MaxFall) {
                        whatMaxFall = new StringBuilder(String.valueOf(i));
                    }
                    MaxFall = Fall;
                }
                if ((PosTransitions + NegTransitions) >= MaxTransitions) {
                    if (PosTransitions + NegTransitions == MaxTransitions) {
                        //append (,x)
                        whatMaxTransitions.append(",").append(i);
                    }
                    //if > eradicate old list start anew
                    if (PosTransitions + NegTransitions > MaxTransitions) {
                        whatMaxTransitions = new StringBuilder(String.valueOf(i));
                    }
                    MaxTransitions = (PosTransitions + NegTransitions);

                }
                if (PosTransitions >= MaxPosTransitions) {
                    if (PosTransitions == MaxPosTransitions) {
                        //append (,x)
                        whatMaxPosTransitions.append(",").append(i);
                    }
                    //if > eradicate old list start anew
                    if (PosTransitions > MaxPosTransitions) {
                        whatMaxPosTransitions = new StringBuilder(String.valueOf(i));
                    }
                    MaxPosTransitions = PosTransitions;
                }
                if (NegTransitions >= MaxNegTransitions) {
                    if (NegTransitions == MaxNegTransitions) {
                        //append (,x)
                        whatMaxNegTransitions.append(",").append(i);
                    }
                    //if > eradicate old list start anew
                    if (NegTransitions > MaxNegTransitions) {
                        whatMaxNegTransitions = new StringBuilder(String.valueOf(i));
                    }
                    MaxNegTransitions = NegTransitions;
                }


            }
            /////////////////////////////////////////////////////////////////////////
            /*
            calculate and spew results
             */
            int count = numTwo - numOne + 1;
            AvgLength = TotLength / (double) count;
            AvgHeight = (double) TotHeight / count;
            AvgRise = (double) TotRise / count;
            AvgFall = (double) TotFall / count;
            AvgTransitions = (double) TotTransitions / count;
            AvgPosTransitions = (double) TotPosTransitions / count;
            AvgNegTransitions = (double) TotNegTransitions / count;

            System.out.println("Max Length: " + MaxLength + " (" + whatMaxLength + ") " + " / Avg Length: " + AvgLength);
            System.out.println("Max Height: " + MaxHeight + " (" + whatMaxHeight + ") " + " / Avg Height: " + AvgHeight);
            System.out.println("Max Rise: " + MaxRise + " (" + whatMaxRise + ") " + " / Avg Rise: " + AvgRise);
            System.out.println("Max Fall: " + MaxFall + " (" + whatMaxFall + ") " + " / Avg Fall: " + AvgFall);
            System.out.println("Max Transitions: " + MaxTransitions + " (" + whatMaxTransitions + ") " + " / Avg Transitions: " + AvgTransitions);
            System.out.println("Max PosTransitions: " + MaxPosTransitions + " (" + whatMaxPosTransitions + ") " + " / Avg PosTransitions: " + AvgPosTransitions);
            System.out.println("Max NegTransitions: " + MaxNegTransitions + " (" + whatMaxNegTransitions + ") " + " / Avg NegTransitions: " + AvgNegTransitions);

            System.exit(0);
        }
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// help
        if (input.contains("-h") || input.contains("?") || input.contains("help")) {
            System.out.println("No Input Value. \n" +
                    "Compute Collatz sequences for the range of test values 1 to 100 million (see Range of Values). \n" +
                    "Example: ./project1\n" +
                    "\n" +
                    "Single Value. \n" +
                    "Compute the Collatz sequence for the specified test value. \n" +
                    "Example: ./project1 6 \n" +
                    "\n" +
                    "Range of Values. \n" +
                    "Compute Collatz sequences for the specified range of test values (inclusively). \n" +
                    "Note: Max legal range is 1:100000000 (100 million). \n" +
                    "Example: ./project1 1:10);) \n");
            System.exit(0);
        }


        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// just the one
        long co = Integer.parseInt(input);
        long n = co;
        System.out.print(co);
        long fall = 0;
        int preTrans = 2;
        if (co == 1) {
            Length = 3;
            Height = 4;
            Fall = 3;
        }
        while (co != 1) {
            ////////////////////////////////////////////length
            Length++;
            ////////////////////////////////////////////height
            if (co > Height) {
                Height = co;
            }
            long preNum = co;
            co = collatz(co);/////////////////////////////////////////collatz
            /////////////////////////////////////////////////////Transitions
            if (co > n && preTrans == 0) {
                PosTransitions++;
                preTrans = 1;
            }
            else {
                if (co < n && preTrans == 1) {
                    NegTransitions++;
                    preTrans = 0;
                }
                else {
                    if (co > n) {
                        preTrans = 1;
                    }
                    else {
                        if (co < n) {
                            preTrans = 0;
                        }
                    }
                }

            }
            /////////////////////////////////////////////rise
            long rise = co - preNum;
            if (rise > Rise) {
                Rise = rise;
            }
            /////////////////////////////////////////////fall
            if (preNum > co) {
                fall = fall + (preNum - co);
            }
            else {
                if (fall > Fall) {
                    Fall = fall;
                }
                fall = 0;
            }
            if (fall > Fall) {
                Fall = fall;
            }
            System.out.print("->" + co);
            if (co < 0) {
                System.exit(666);
            }
        }
        System.out.println("\n\nlength: " + Length);
        System.out.println("height: " + Height);
        System.out.println("rise: " + Rise);
        System.out.println("fall: " + Fall);
        System.out.println("Total Transitions: " + (PosTransitions + NegTransitions));
        System.out.println("# Pos Transitions: " + PosTransitions);
        System.out.println("# Neg Transitions: " + NegTransitions);
    }

    public static long collatz(long num) {
        if (num % 2 == 0) {
            num = num / 2;
        }
        else {
            num = num * 3 + 1;
        }
        return (num);
    }
}
