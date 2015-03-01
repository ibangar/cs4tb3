package com.pascalindent;

import com.pascalindent.antlr.Pascal0Lexer;
import com.pascalindent.antlr.Pascal0Parser;
import com.pascalindent.antlr.Pascal0BaseListener;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class PascalIndent
{
    InputStream mInput;
    CharStream mCharStream;

    Pascal0Lexer mLexer;
    Pascal0Parser mParser;

    public PascalIndent(String[] args)
    {
        /* open file */
        System.out.println(args[0]);
        try
        {
            mInput = new FileInputStream(new File(args[0]));
            mCharStream = new ANTLRInputStream(mInput);
        }
        catch (Exception e)
        {
            System.out.println("Failed to open file and created CharStream : " + e.getMessage());
        }

        /* create lexer and parser */
        mLexer = new Pascal0Lexer(mCharStream);
        CommonTokenStream tokenStream = new CommonTokenStream(mLexer);
        mParser = new Pascal0Parser(tokenStream);

        /* walk the program */
        Pascal0Parser.ProgramContext program = mParser.program();
        ParseTreeWalker walker = new ParseTreeWalker();

        walker.walk(new Pascal0BaseListener() {
            public void enterProgram(Pascal0Parser.ProgramContext ctx)
            {
                System.out.println("enter program");
            }
        }, program);
    }

    public static final void main(String[] args)
    {
        PascalIndent instance = new PascalIndent(args);
    }
}
