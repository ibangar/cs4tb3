package com.pascalindent;

import com.pascalindent.antlr.Pascal0BaseListener;
import com.pascalindent.antlr.Pascal0Parser;

import org.antlr.v4.runtime.tree.TerminalNode;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

public class PascalIndentConverter extends Pascal0BaseListener
{
    OutputStream mOutput;

    int mIndentLevel = 0;

    public PascalIndentConverter(OutputStream output)
    {
        mOutput = output;
    }

    @Override
    public void enterProgram(Pascal0Parser.ProgramContext ctx)
	{
        List<TerminalNode> ident = ctx.Ident();

        /* 'program' Ident */
        print("program " + ident.get(0).getText());
        mIndentLevel++;

        /* ['(' Ident {',' Ident} ')'] ';' */
        for (int i = 1; i < ident.size(); i++)
        {
            String identText = ident.get(i).getText();

            if (i == 1)
            {
                print("(");
                print(identText);
            }
            else if (i == ident.size() - 1)
            {
                print(", " + identText + ")");
            }
            else
            {
                print(", " + identText);
            }
        }
        print(";\n");
	}

    @Override
    public void exitProgram(Pascal0Parser.ProgramContext ctx)
	{
	}

    @Override
    public void enterSelector(Pascal0Parser.SelectorContext ctx)
	{
        List<TerminalNode> ident = ctx.Ident();
        List<Pascal0Parser.ExpressionContext>
	}

    @Override
    public void exitSelector(Pascal0Parser.SelectorContext ctx)
	{
	}

    @Override
    public void enterExpression(Pascal0Parser.ExpressionContext ctx)
	{
	}

    @Override
    public void exitExpression(Pascal0Parser.ExpressionContext ctx)
	{
	}

    @Override
    public void enterSimpleexpression(Pascal0Parser.SimpleexpressionContext ctx)
	{
	}

    @Override
    public void exitSimpleexpression(Pascal0Parser.SimpleexpressionContext ctx)
	{
	}

    @Override
    public void enterFactor(Pascal0Parser.FactorContext ctx)
	{
	}

    @Override
    public void exitFactor(Pascal0Parser.FactorContext ctx)
	{
	}

    @Override
    public void enterTerm(Pascal0Parser.TermContext ctx)
	{
	}

    @Override
    public void exitTerm(Pascal0Parser.TermContext ctx)
	{
	}

    @Override
    public void enterAssignment(Pascal0Parser.AssignmentContext ctx)
	{
	}

    @Override
    public void exitAssignment(Pascal0Parser.AssignmentContext ctx)
	{
	}

    @Override
    public void enterActualparameters(Pascal0Parser.ActualparametersContext ctx)
	{
	}

    @Override
    public void exitActualparameters(Pascal0Parser.ActualparametersContext ctx)
	{
	}

    @Override
    public void enterProcedurecall(Pascal0Parser.ProcedurecallContext ctx)
	{
	}

    @Override
    public void exitProcedurecall(Pascal0Parser.ProcedurecallContext ctx)
	{
	}

    @Override
    public void enterCompoundstatement(Pascal0Parser.CompoundstatementContext ctx)
	{
	}

    @Override
    public void exitCompoundstatement(Pascal0Parser.CompoundstatementContext ctx)
	{
	}

    @Override
    public void enterIfstatement(Pascal0Parser.IfstatementContext ctx)
	{
	}

    @Override
    public void exitIfstatement(Pascal0Parser.IfstatementContext ctx)
	{
	}

    @Override
    public void enterWhilestatement(Pascal0Parser.WhilestatementContext ctx)
	{
	}

    @Override
    public void exitWhilestatement(Pascal0Parser.WhilestatementContext ctx)
	{
	}

    @Override
    public void enterStatement(Pascal0Parser.StatementContext ctx)
	{
	}

    @Override
    public void exitStatement(Pascal0Parser.StatementContext ctx)
	{
	}

    @Override
    public void enterIdentlist(Pascal0Parser.IdentlistContext ctx)
	{
	}

    @Override
    public void exitIdentlist(Pascal0Parser.IdentlistContext ctx)
	{
	}

    @Override
    public void enterArraytype(Pascal0Parser.ArraytypeContext ctx)
	{
	}

    @Override
    public void exitArraytype(Pascal0Parser.ArraytypeContext ctx)
	{
	}

    @Override
    public void enterFieldlist(Pascal0Parser.FieldlistContext ctx)
	{
	}

    @Override
    public void exitFieldlist(Pascal0Parser.FieldlistContext ctx)
	{
	}

    @Override
    public void enterRecordtype(Pascal0Parser.RecordtypeContext ctx)
	{
	}

    @Override
    public void exitRecordtype(Pascal0Parser.RecordtypeContext ctx)
	{
	}

    @Override
    public void enterType(Pascal0Parser.TypeContext ctx)
	{
	}

    @Override
    public void exitType(Pascal0Parser.TypeContext ctx)
	{
	}

    @Override
    public void enterFpsection(Pascal0Parser.FpsectionContext ctx)
	{
	}

    @Override
    public void exitFpsection(Pascal0Parser.FpsectionContext ctx)
	{
	}

    @Override
    public void enterFormalparameters(Pascal0Parser.FormalparametersContext ctx)
	{
	}

    @Override
    public void exitFormalparameters(Pascal0Parser.FormalparametersContext ctx)
	{
	}

    @Override
    public void enterProcdeclaration(Pascal0Parser.ProcdeclarationContext ctx)
	{
	}

    @Override
    public void exitProcdeclaration(Pascal0Parser.ProcdeclarationContext ctx)
	{
	}

    @Override
    public void enterDeclarations(Pascal0Parser.DeclarationsContext ctx)
	{
	}

    @Override
    public void exitDeclarations(Pascal0Parser.DeclarationsContext ctx)
	{
	}

    private void print(String string)
    {
        try
        {
            mOutput.write(string.getBytes());
        }
        catch (IOException e)
        {
            System.out.println("Failed to write to output file : " + e.getMessage());
        }
    }
}
