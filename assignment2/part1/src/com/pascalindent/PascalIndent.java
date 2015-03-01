package com.pascalindent;

import com.pascalindent.antlr.Pascal0Lexer;
import com.pascalindent.antlr.Pascal0Parser;
import com.pascalindent.antlr.Pascal0BaseListener;
import com.pascalindent.PascalIndentConverter;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

public class PascalIndent
{
    InputStream mInput;
    OutputStream mOutput;
    CharStream mCharStream;

    Pascal0Lexer mLexer;
    Pascal0Parser mParser;

    public PascalIndent(String[] args)
    {
        /* open input and output files */
        try
        {
            /* open input file */
            mInput = new FileInputStream(new File(args[0]));
            mCharStream = new ANTLRInputStream(mInput);

            /* open output file */
            mOutput = new FileOutputStream(new File(args[1]));
        }
        catch (Exception e)
        {
            System.out.println("Failed to open input/output files : " + e.getMessage());
            return;
        }

        /* create lexer and parser */
        mLexer = new Pascal0Lexer(mCharStream);
        CommonTokenStream tokenStream = new CommonTokenStream(mLexer);
        mParser = new Pascal0Parser(tokenStream);

        /* create walker */
        Pascal0Parser.ProgramContext program = mParser.program();
        ParseTreeWalker walker = new ParseTreeWalker();

        /* walk through the program */
        walker.walk(new PascalIndentConverter(mOutput), program);
    }

    public static final void main(String[] args)
    {
        PascalIndent instance = new PascalIndent(args);
    }
}
