// Generated from /Users/panashe/workplace/2025/shonascript-studio/Shonascriptx.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ShonascriptxParser}.
 */
public interface ShonascriptxListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ShonascriptxParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(ShonascriptxParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShonascriptxParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(ShonascriptxParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShonascriptxParser#programElement}.
	 * @param ctx the parse tree
	 */
	void enterProgramElement(ShonascriptxParser.ProgramElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShonascriptxParser#programElement}.
	 * @param ctx the parse tree
	 */
	void exitProgramElement(ShonascriptxParser.ProgramElementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShonascriptxParser#line}.
	 * @param ctx the parse tree
	 */
	void enterLine(ShonascriptxParser.LineContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShonascriptxParser#line}.
	 * @param ctx the parse tree
	 */
	void exitLine(ShonascriptxParser.LineContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShonascriptxParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(ShonascriptxParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShonascriptxParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(ShonascriptxParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShonascriptxParser#simpleStatement}.
	 * @param ctx the parse tree
	 */
	void enterSimpleStatement(ShonascriptxParser.SimpleStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShonascriptxParser#simpleStatement}.
	 * @param ctx the parse tree
	 */
	void exitSimpleStatement(ShonascriptxParser.SimpleStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShonascriptxParser#reactiveOneLiner}.
	 * @param ctx the parse tree
	 */
	void enterReactiveOneLiner(ShonascriptxParser.ReactiveOneLinerContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShonascriptxParser#reactiveOneLiner}.
	 * @param ctx the parse tree
	 */
	void exitReactiveOneLiner(ShonascriptxParser.ReactiveOneLinerContext ctx);
	/**
	 * Enter a parse tree produced by the {@code reactiveBlockStmt}
	 * labeled alternative in {@link ShonascriptxParser#reactiveBlock}.
	 * @param ctx the parse tree
	 */
	void enterReactiveBlockStmt(ShonascriptxParser.ReactiveBlockStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code reactiveBlockStmt}
	 * labeled alternative in {@link ShonascriptxParser#reactiveBlock}.
	 * @param ctx the parse tree
	 */
	void exitReactiveBlockStmt(ShonascriptxParser.ReactiveBlockStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShonascriptxParser#linearObjectDefinition}.
	 * @param ctx the parse tree
	 */
	void enterLinearObjectDefinition(ShonascriptxParser.LinearObjectDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShonascriptxParser#linearObjectDefinition}.
	 * @param ctx the parse tree
	 */
	void exitLinearObjectDefinition(ShonascriptxParser.LinearObjectDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShonascriptxParser#anonymousFunctionAssignment}.
	 * @param ctx the parse tree
	 */
	void enterAnonymousFunctionAssignment(ShonascriptxParser.AnonymousFunctionAssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShonascriptxParser#anonymousFunctionAssignment}.
	 * @param ctx the parse tree
	 */
	void exitAnonymousFunctionAssignment(ShonascriptxParser.AnonymousFunctionAssignmentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code inlineObjectBody}
	 * labeled alternative in {@link ShonascriptxParser#linearObjectBody}.
	 * @param ctx the parse tree
	 */
	void enterInlineObjectBody(ShonascriptxParser.InlineObjectBodyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code inlineObjectBody}
	 * labeled alternative in {@link ShonascriptxParser#linearObjectBody}.
	 * @param ctx the parse tree
	 */
	void exitInlineObjectBody(ShonascriptxParser.InlineObjectBodyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code blockObjectBody}
	 * labeled alternative in {@link ShonascriptxParser#linearObjectBody}.
	 * @param ctx the parse tree
	 */
	void enterBlockObjectBody(ShonascriptxParser.BlockObjectBodyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code blockObjectBody}
	 * labeled alternative in {@link ShonascriptxParser#linearObjectBody}.
	 * @param ctx the parse tree
	 */
	void exitBlockObjectBody(ShonascriptxParser.BlockObjectBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShonascriptxParser#linearObjectEntries}.
	 * @param ctx the parse tree
	 */
	void enterLinearObjectEntries(ShonascriptxParser.LinearObjectEntriesContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShonascriptxParser#linearObjectEntries}.
	 * @param ctx the parse tree
	 */
	void exitLinearObjectEntries(ShonascriptxParser.LinearObjectEntriesContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShonascriptxParser#linearObjectEntry}.
	 * @param ctx the parse tree
	 */
	void enterLinearObjectEntry(ShonascriptxParser.LinearObjectEntryContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShonascriptxParser#linearObjectEntry}.
	 * @param ctx the parse tree
	 */
	void exitLinearObjectEntry(ShonascriptxParser.LinearObjectEntryContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShonascriptxParser#objectEntries}.
	 * @param ctx the parse tree
	 */
	void enterObjectEntries(ShonascriptxParser.ObjectEntriesContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShonascriptxParser#objectEntries}.
	 * @param ctx the parse tree
	 */
	void exitObjectEntries(ShonascriptxParser.ObjectEntriesContext ctx);
	/**
	 * Enter a parse tree produced by the {@code objValue}
	 * labeled alternative in {@link ShonascriptxParser#objectEntry}.
	 * @param ctx the parse tree
	 */
	void enterObjValue(ShonascriptxParser.ObjValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code objValue}
	 * labeled alternative in {@link ShonascriptxParser#objectEntry}.
	 * @param ctx the parse tree
	 */
	void exitObjValue(ShonascriptxParser.ObjValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code nestedObj}
	 * labeled alternative in {@link ShonascriptxParser#objectEntry}.
	 * @param ctx the parse tree
	 */
	void enterNestedObj(ShonascriptxParser.NestedObjContext ctx);
	/**
	 * Exit a parse tree produced by the {@code nestedObj}
	 * labeled alternative in {@link ShonascriptxParser#objectEntry}.
	 * @param ctx the parse tree
	 */
	void exitNestedObj(ShonascriptxParser.NestedObjContext ctx);
	/**
	 * Enter a parse tree produced by the {@code emptyNestedObj}
	 * labeled alternative in {@link ShonascriptxParser#objectEntry}.
	 * @param ctx the parse tree
	 */
	void enterEmptyNestedObj(ShonascriptxParser.EmptyNestedObjContext ctx);
	/**
	 * Exit a parse tree produced by the {@code emptyNestedObj}
	 * labeled alternative in {@link ShonascriptxParser#objectEntry}.
	 * @param ctx the parse tree
	 */
	void exitEmptyNestedObj(ShonascriptxParser.EmptyNestedObjContext ctx);
	/**
	 * Enter a parse tree produced by the {@code inlineNestedObj}
	 * labeled alternative in {@link ShonascriptxParser#objectEntry}.
	 * @param ctx the parse tree
	 */
	void enterInlineNestedObj(ShonascriptxParser.InlineNestedObjContext ctx);
	/**
	 * Exit a parse tree produced by the {@code inlineNestedObj}
	 * labeled alternative in {@link ShonascriptxParser#objectEntry}.
	 * @param ctx the parse tree
	 */
	void exitInlineNestedObj(ShonascriptxParser.InlineNestedObjContext ctx);
	/**
	 * Enter a parse tree produced by the {@code objMethod}
	 * labeled alternative in {@link ShonascriptxParser#objectEntry}.
	 * @param ctx the parse tree
	 */
	void enterObjMethod(ShonascriptxParser.ObjMethodContext ctx);
	/**
	 * Exit a parse tree produced by the {@code objMethod}
	 * labeled alternative in {@link ShonascriptxParser#objectEntry}.
	 * @param ctx the parse tree
	 */
	void exitObjMethod(ShonascriptxParser.ObjMethodContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShonascriptxParser#propsDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterPropsDeclaration(ShonascriptxParser.PropsDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShonascriptxParser#propsDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitPropsDeclaration(ShonascriptxParser.PropsDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShonascriptxParser#compoundStatement}.
	 * @param ctx the parse tree
	 */
	void enterCompoundStatement(ShonascriptxParser.CompoundStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShonascriptxParser#compoundStatement}.
	 * @param ctx the parse tree
	 */
	void exitCompoundStatement(ShonascriptxParser.CompoundStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShonascriptxParser#incrementStatement}.
	 * @param ctx the parse tree
	 */
	void enterIncrementStatement(ShonascriptxParser.IncrementStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShonascriptxParser#incrementStatement}.
	 * @param ctx the parse tree
	 */
	void exitIncrementStatement(ShonascriptxParser.IncrementStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShonascriptxParser#decrementStatement}.
	 * @param ctx the parse tree
	 */
	void enterDecrementStatement(ShonascriptxParser.DecrementStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShonascriptxParser#decrementStatement}.
	 * @param ctx the parse tree
	 */
	void exitDecrementStatement(ShonascriptxParser.DecrementStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShonascriptxParser#compoundAssignment}.
	 * @param ctx the parse tree
	 */
	void enterCompoundAssignment(ShonascriptxParser.CompoundAssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShonascriptxParser#compoundAssignment}.
	 * @param ctx the parse tree
	 */
	void exitCompoundAssignment(ShonascriptxParser.CompoundAssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShonascriptxParser#compoundOp}.
	 * @param ctx the parse tree
	 */
	void enterCompoundOp(ShonascriptxParser.CompoundOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShonascriptxParser#compoundOp}.
	 * @param ctx the parse tree
	 */
	void exitCompoundOp(ShonascriptxParser.CompoundOpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code newSet}
	 * labeled alternative in {@link ShonascriptxParser#setDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterNewSet(ShonascriptxParser.NewSetContext ctx);
	/**
	 * Exit a parse tree produced by the {@code newSet}
	 * labeled alternative in {@link ShonascriptxParser#setDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitNewSet(ShonascriptxParser.NewSetContext ctx);
	/**
	 * Enter a parse tree produced by the {@code arrayToSet}
	 * labeled alternative in {@link ShonascriptxParser#setDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterArrayToSet(ShonascriptxParser.ArrayToSetContext ctx);
	/**
	 * Exit a parse tree produced by the {@code arrayToSet}
	 * labeled alternative in {@link ShonascriptxParser#setDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitArrayToSet(ShonascriptxParser.ArrayToSetContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprToSet}
	 * labeled alternative in {@link ShonascriptxParser#setDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterExprToSet(ShonascriptxParser.ExprToSetContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprToSet}
	 * labeled alternative in {@link ShonascriptxParser#setDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitExprToSet(ShonascriptxParser.ExprToSetContext ctx);
	/**
	 * Enter a parse tree produced by the {@code defaultSort}
	 * labeled alternative in {@link ShonascriptxParser#sortStatement}.
	 * @param ctx the parse tree
	 */
	void enterDefaultSort(ShonascriptxParser.DefaultSortContext ctx);
	/**
	 * Exit a parse tree produced by the {@code defaultSort}
	 * labeled alternative in {@link ShonascriptxParser#sortStatement}.
	 * @param ctx the parse tree
	 */
	void exitDefaultSort(ShonascriptxParser.DefaultSortContext ctx);
	/**
	 * Enter a parse tree produced by the {@code descendingSort}
	 * labeled alternative in {@link ShonascriptxParser#sortStatement}.
	 * @param ctx the parse tree
	 */
	void enterDescendingSort(ShonascriptxParser.DescendingSortContext ctx);
	/**
	 * Exit a parse tree produced by the {@code descendingSort}
	 * labeled alternative in {@link ShonascriptxParser#sortStatement}.
	 * @param ctx the parse tree
	 */
	void exitDescendingSort(ShonascriptxParser.DescendingSortContext ctx);
	/**
	 * Enter a parse tree produced by the {@code objectDescSort}
	 * labeled alternative in {@link ShonascriptxParser#sortStatement}.
	 * @param ctx the parse tree
	 */
	void enterObjectDescSort(ShonascriptxParser.ObjectDescSortContext ctx);
	/**
	 * Exit a parse tree produced by the {@code objectDescSort}
	 * labeled alternative in {@link ShonascriptxParser#sortStatement}.
	 * @param ctx the parse tree
	 */
	void exitObjectDescSort(ShonascriptxParser.ObjectDescSortContext ctx);
	/**
	 * Enter a parse tree produced by the {@code objectAscSort}
	 * labeled alternative in {@link ShonascriptxParser#sortStatement}.
	 * @param ctx the parse tree
	 */
	void enterObjectAscSort(ShonascriptxParser.ObjectAscSortContext ctx);
	/**
	 * Exit a parse tree produced by the {@code objectAscSort}
	 * labeled alternative in {@link ShonascriptxParser#sortStatement}.
	 * @param ctx the parse tree
	 */
	void exitObjectAscSort(ShonascriptxParser.ObjectAscSortContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ascendingSort}
	 * labeled alternative in {@link ShonascriptxParser#sortStatement}.
	 * @param ctx the parse tree
	 */
	void enterAscendingSort(ShonascriptxParser.AscendingSortContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ascendingSort}
	 * labeled alternative in {@link ShonascriptxParser#sortStatement}.
	 * @param ctx the parse tree
	 */
	void exitAscendingSort(ShonascriptxParser.AscendingSortContext ctx);
	/**
	 * Enter a parse tree produced by the {@code objectFilter}
	 * labeled alternative in {@link ShonascriptxParser#filterStatement}.
	 * @param ctx the parse tree
	 */
	void enterObjectFilter(ShonascriptxParser.ObjectFilterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code objectFilter}
	 * labeled alternative in {@link ShonascriptxParser#filterStatement}.
	 * @param ctx the parse tree
	 */
	void exitObjectFilter(ShonascriptxParser.ObjectFilterContext ctx);
	/**
	 * Enter a parse tree produced by the {@code nounClassFilter}
	 * labeled alternative in {@link ShonascriptxParser#filterStatement}.
	 * @param ctx the parse tree
	 */
	void enterNounClassFilter(ShonascriptxParser.NounClassFilterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code nounClassFilter}
	 * labeled alternative in {@link ShonascriptxParser#filterStatement}.
	 * @param ctx the parse tree
	 */
	void exitNounClassFilter(ShonascriptxParser.NounClassFilterContext ctx);
	/**
	 * Enter a parse tree produced by the {@code primitiveFilter}
	 * labeled alternative in {@link ShonascriptxParser#filterStatement}.
	 * @param ctx the parse tree
	 */
	void enterPrimitiveFilter(ShonascriptxParser.PrimitiveFilterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code primitiveFilter}
	 * labeled alternative in {@link ShonascriptxParser#filterStatement}.
	 * @param ctx the parse tree
	 */
	void exitPrimitiveFilter(ShonascriptxParser.PrimitiveFilterContext ctx);
	/**
	 * Enter a parse tree produced by the {@code directValueFilter}
	 * labeled alternative in {@link ShonascriptxParser#filterStatement}.
	 * @param ctx the parse tree
	 */
	void enterDirectValueFilter(ShonascriptxParser.DirectValueFilterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code directValueFilter}
	 * labeled alternative in {@link ShonascriptxParser#filterStatement}.
	 * @param ctx the parse tree
	 */
	void exitDirectValueFilter(ShonascriptxParser.DirectValueFilterContext ctx);
	/**
	 * Enter a parse tree produced by the {@code complexFilter}
	 * labeled alternative in {@link ShonascriptxParser#filterStatement}.
	 * @param ctx the parse tree
	 */
	void enterComplexFilter(ShonascriptxParser.ComplexFilterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code complexFilter}
	 * labeled alternative in {@link ShonascriptxParser#filterStatement}.
	 * @param ctx the parse tree
	 */
	void exitComplexFilter(ShonascriptxParser.ComplexFilterContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShonascriptxParser#logicalFilterExpression}.
	 * @param ctx the parse tree
	 */
	void enterLogicalFilterExpression(ShonascriptxParser.LogicalFilterExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShonascriptxParser#logicalFilterExpression}.
	 * @param ctx the parse tree
	 */
	void exitLogicalFilterExpression(ShonascriptxParser.LogicalFilterExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShonascriptxParser#comparisonOperator}.
	 * @param ctx the parse tree
	 */
	void enterComparisonOperator(ShonascriptxParser.ComparisonOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShonascriptxParser#comparisonOperator}.
	 * @param ctx the parse tree
	 */
	void exitComparisonOperator(ShonascriptxParser.ComparisonOperatorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code htmlBlockElement}
	 * labeled alternative in {@link ShonascriptxParser#htmlElement}.
	 * @param ctx the parse tree
	 */
	void enterHtmlBlockElement(ShonascriptxParser.HtmlBlockElementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code htmlBlockElement}
	 * labeled alternative in {@link ShonascriptxParser#htmlElement}.
	 * @param ctx the parse tree
	 */
	void exitHtmlBlockElement(ShonascriptxParser.HtmlBlockElementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code htmlSelfClosingElement}
	 * labeled alternative in {@link ShonascriptxParser#htmlElement}.
	 * @param ctx the parse tree
	 */
	void enterHtmlSelfClosingElement(ShonascriptxParser.HtmlSelfClosingElementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code htmlSelfClosingElement}
	 * labeled alternative in {@link ShonascriptxParser#htmlElement}.
	 * @param ctx the parse tree
	 */
	void exitHtmlSelfClosingElement(ShonascriptxParser.HtmlSelfClosingElementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code htmlVoidElement}
	 * labeled alternative in {@link ShonascriptxParser#htmlElement}.
	 * @param ctx the parse tree
	 */
	void enterHtmlVoidElement(ShonascriptxParser.HtmlVoidElementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code htmlVoidElement}
	 * labeled alternative in {@link ShonascriptxParser#htmlElement}.
	 * @param ctx the parse tree
	 */
	void exitHtmlVoidElement(ShonascriptxParser.HtmlVoidElementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShonascriptxParser#tagName}.
	 * @param ctx the parse tree
	 */
	void enterTagName(ShonascriptxParser.TagNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShonascriptxParser#tagName}.
	 * @param ctx the parse tree
	 */
	void exitTagName(ShonascriptxParser.TagNameContext ctx);
	/**
	 * Enter a parse tree produced by the {@code htmlAttribute}
	 * labeled alternative in {@link ShonascriptxParser#attribute}.
	 * @param ctx the parse tree
	 */
	void enterHtmlAttribute(ShonascriptxParser.HtmlAttributeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code htmlAttribute}
	 * labeled alternative in {@link ShonascriptxParser#attribute}.
	 * @param ctx the parse tree
	 */
	void exitHtmlAttribute(ShonascriptxParser.HtmlAttributeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code htmlEventHandler}
	 * labeled alternative in {@link ShonascriptxParser#attribute}.
	 * @param ctx the parse tree
	 */
	void enterHtmlEventHandler(ShonascriptxParser.HtmlEventHandlerContext ctx);
	/**
	 * Exit a parse tree produced by the {@code htmlEventHandler}
	 * labeled alternative in {@link ShonascriptxParser#attribute}.
	 * @param ctx the parse tree
	 */
	void exitHtmlEventHandler(ShonascriptxParser.HtmlEventHandlerContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShonascriptxParser#attrName}.
	 * @param ctx the parse tree
	 */
	void enterAttrName(ShonascriptxParser.AttrNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShonascriptxParser#attrName}.
	 * @param ctx the parse tree
	 */
	void exitAttrName(ShonascriptxParser.AttrNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShonascriptxParser#eventHandler}.
	 * @param ctx the parse tree
	 */
	void enterEventHandler(ShonascriptxParser.EventHandlerContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShonascriptxParser#eventHandler}.
	 * @param ctx the parse tree
	 */
	void exitEventHandler(ShonascriptxParser.EventHandlerContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShonascriptxParser#htmlContent}.
	 * @param ctx the parse tree
	 */
	void enterHtmlContent(ShonascriptxParser.HtmlContentContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShonascriptxParser#htmlContent}.
	 * @param ctx the parse tree
	 */
	void exitHtmlContent(ShonascriptxParser.HtmlContentContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShonascriptxParser#htmlContentElement}.
	 * @param ctx the parse tree
	 */
	void enterHtmlContentElement(ShonascriptxParser.HtmlContentElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShonascriptxParser#htmlContentElement}.
	 * @param ctx the parse tree
	 */
	void exitHtmlContentElement(ShonascriptxParser.HtmlContentElementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShonascriptxParser#shonaControlFlow}.
	 * @param ctx the parse tree
	 */
	void enterShonaControlFlow(ShonascriptxParser.ShonaControlFlowContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShonascriptxParser#shonaControlFlow}.
	 * @param ctx the parse tree
	 */
	void exitShonaControlFlow(ShonascriptxParser.ShonaControlFlowContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShonascriptxParser#conditionalInHtml}.
	 * @param ctx the parse tree
	 */
	void enterConditionalInHtml(ShonascriptxParser.ConditionalInHtmlContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShonascriptxParser#conditionalInHtml}.
	 * @param ctx the parse tree
	 */
	void exitConditionalInHtml(ShonascriptxParser.ConditionalInHtmlContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShonascriptxParser#htmlContentUntilKeyword}.
	 * @param ctx the parse tree
	 */
	void enterHtmlContentUntilKeyword(ShonascriptxParser.HtmlContentUntilKeywordContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShonascriptxParser#htmlContentUntilKeyword}.
	 * @param ctx the parse tree
	 */
	void exitHtmlContentUntilKeyword(ShonascriptxParser.HtmlContentUntilKeywordContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShonascriptxParser#htmlContentToEnd}.
	 * @param ctx the parse tree
	 */
	void enterHtmlContentToEnd(ShonascriptxParser.HtmlContentToEndContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShonascriptxParser#htmlContentToEnd}.
	 * @param ctx the parse tree
	 */
	void exitHtmlContentToEnd(ShonascriptxParser.HtmlContentToEndContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShonascriptxParser#htmlContentPart}.
	 * @param ctx the parse tree
	 */
	void enterHtmlContentPart(ShonascriptxParser.HtmlContentPartContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShonascriptxParser#htmlContentPart}.
	 * @param ctx the parse tree
	 */
	void exitHtmlContentPart(ShonascriptxParser.HtmlContentPartContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShonascriptxParser#htmlTextNotKeyword}.
	 * @param ctx the parse tree
	 */
	void enterHtmlTextNotKeyword(ShonascriptxParser.HtmlTextNotKeywordContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShonascriptxParser#htmlTextNotKeyword}.
	 * @param ctx the parse tree
	 */
	void exitHtmlTextNotKeyword(ShonascriptxParser.HtmlTextNotKeywordContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShonascriptxParser#htmlTextContentNotKeyword}.
	 * @param ctx the parse tree
	 */
	void enterHtmlTextContentNotKeyword(ShonascriptxParser.HtmlTextContentNotKeywordContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShonascriptxParser#htmlTextContentNotKeyword}.
	 * @param ctx the parse tree
	 */
	void exitHtmlTextContentNotKeyword(ShonascriptxParser.HtmlTextContentNotKeywordContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShonascriptxParser#loopInHtml}.
	 * @param ctx the parse tree
	 */
	void enterLoopInHtml(ShonascriptxParser.LoopInHtmlContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShonascriptxParser#loopInHtml}.
	 * @param ctx the parse tree
	 */
	void exitLoopInHtml(ShonascriptxParser.LoopInHtmlContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShonascriptxParser#whileInHtml}.
	 * @param ctx the parse tree
	 */
	void enterWhileInHtml(ShonascriptxParser.WhileInHtmlContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShonascriptxParser#whileInHtml}.
	 * @param ctx the parse tree
	 */
	void exitWhileInHtml(ShonascriptxParser.WhileInHtmlContext ctx);
	/**
	 * Enter a parse tree produced by the {@code htmlBlockSuite}
	 * labeled alternative in {@link ShonascriptxParser#htmlSuite}.
	 * @param ctx the parse tree
	 */
	void enterHtmlBlockSuite(ShonascriptxParser.HtmlBlockSuiteContext ctx);
	/**
	 * Exit a parse tree produced by the {@code htmlBlockSuite}
	 * labeled alternative in {@link ShonascriptxParser#htmlSuite}.
	 * @param ctx the parse tree
	 */
	void exitHtmlBlockSuite(ShonascriptxParser.HtmlBlockSuiteContext ctx);
	/**
	 * Enter a parse tree produced by the {@code htmlIndentedSuite}
	 * labeled alternative in {@link ShonascriptxParser#htmlSuite}.
	 * @param ctx the parse tree
	 */
	void enterHtmlIndentedSuite(ShonascriptxParser.HtmlIndentedSuiteContext ctx);
	/**
	 * Exit a parse tree produced by the {@code htmlIndentedSuite}
	 * labeled alternative in {@link ShonascriptxParser#htmlSuite}.
	 * @param ctx the parse tree
	 */
	void exitHtmlIndentedSuite(ShonascriptxParser.HtmlIndentedSuiteContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShonascriptxParser#shonaExpression}.
	 * @param ctx the parse tree
	 */
	void enterShonaExpression(ShonascriptxParser.ShonaExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShonascriptxParser#shonaExpression}.
	 * @param ctx the parse tree
	 */
	void exitShonaExpression(ShonascriptxParser.ShonaExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShonascriptxParser#htmlText}.
	 * @param ctx the parse tree
	 */
	void enterHtmlText(ShonascriptxParser.HtmlTextContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShonascriptxParser#htmlText}.
	 * @param ctx the parse tree
	 */
	void exitHtmlText(ShonascriptxParser.HtmlTextContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShonascriptxParser#htmlTextContent}.
	 * @param ctx the parse tree
	 */
	void enterHtmlTextContent(ShonascriptxParser.HtmlTextContentContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShonascriptxParser#htmlTextContent}.
	 * @param ctx the parse tree
	 */
	void exitHtmlTextContent(ShonascriptxParser.HtmlTextContentContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShonascriptxParser#inputStatement}.
	 * @param ctx the parse tree
	 */
	void enterInputStatement(ShonascriptxParser.InputStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShonascriptxParser#inputStatement}.
	 * @param ctx the parse tree
	 */
	void exitInputStatement(ShonascriptxParser.InputStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShonascriptxParser#importStatement}.
	 * @param ctx the parse tree
	 */
	void enterImportStatement(ShonascriptxParser.ImportStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShonascriptxParser#importStatement}.
	 * @param ctx the parse tree
	 */
	void exitImportStatement(ShonascriptxParser.ImportStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShonascriptxParser#fetchStatement}.
	 * @param ctx the parse tree
	 */
	void enterFetchStatement(ShonascriptxParser.FetchStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShonascriptxParser#fetchStatement}.
	 * @param ctx the parse tree
	 */
	void exitFetchStatement(ShonascriptxParser.FetchStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShonascriptxParser#propName}.
	 * @param ctx the parse tree
	 */
	void enterPropName(ShonascriptxParser.PropNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShonascriptxParser#propName}.
	 * @param ctx the parse tree
	 */
	void exitPropName(ShonascriptxParser.PropNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShonascriptxParser#propertyRef}.
	 * @param ctx the parse tree
	 */
	void enterPropertyRef(ShonascriptxParser.PropertyRefContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShonascriptxParser#propertyRef}.
	 * @param ctx the parse tree
	 */
	void exitPropertyRef(ShonascriptxParser.PropertyRefContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShonascriptxParser#propertyDelete}.
	 * @param ctx the parse tree
	 */
	void enterPropertyDelete(ShonascriptxParser.PropertyDeleteContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShonascriptxParser#propertyDelete}.
	 * @param ctx the parse tree
	 */
	void exitPropertyDelete(ShonascriptxParser.PropertyDeleteContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShonascriptxParser#domSelector}.
	 * @param ctx the parse tree
	 */
	void enterDomSelector(ShonascriptxParser.DomSelectorContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShonascriptxParser#domSelector}.
	 * @param ctx the parse tree
	 */
	void exitDomSelector(ShonascriptxParser.DomSelectorContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShonascriptxParser#domPropertyRef}.
	 * @param ctx the parse tree
	 */
	void enterDomPropertyRef(ShonascriptxParser.DomPropertyRefContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShonascriptxParser#domPropertyRef}.
	 * @param ctx the parse tree
	 */
	void exitDomPropertyRef(ShonascriptxParser.DomPropertyRefContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShonascriptxParser#eventListenerStatement}.
	 * @param ctx the parse tree
	 */
	void enterEventListenerStatement(ShonascriptxParser.EventListenerStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShonascriptxParser#eventListenerStatement}.
	 * @param ctx the parse tree
	 */
	void exitEventListenerStatement(ShonascriptxParser.EventListenerStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShonascriptxParser#classStatement}.
	 * @param ctx the parse tree
	 */
	void enterClassStatement(ShonascriptxParser.ClassStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShonascriptxParser#classStatement}.
	 * @param ctx the parse tree
	 */
	void exitClassStatement(ShonascriptxParser.ClassStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShonascriptxParser#loopStatement}.
	 * @param ctx the parse tree
	 */
	void enterLoopStatement(ShonascriptxParser.LoopStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShonascriptxParser#loopStatement}.
	 * @param ctx the parse tree
	 */
	void exitLoopStatement(ShonascriptxParser.LoopStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShonascriptxParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void enterWhileStatement(ShonascriptxParser.WhileStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShonascriptxParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void exitWhileStatement(ShonascriptxParser.WhileStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShonascriptxParser#intervalStatement}.
	 * @param ctx the parse tree
	 */
	void enterIntervalStatement(ShonascriptxParser.IntervalStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShonascriptxParser#intervalStatement}.
	 * @param ctx the parse tree
	 */
	void exitIntervalStatement(ShonascriptxParser.IntervalStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShonascriptxParser#timeoutStatement}.
	 * @param ctx the parse tree
	 */
	void enterTimeoutStatement(ShonascriptxParser.TimeoutStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShonascriptxParser#timeoutStatement}.
	 * @param ctx the parse tree
	 */
	void exitTimeoutStatement(ShonascriptxParser.TimeoutStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShonascriptxParser#continueStatement}.
	 * @param ctx the parse tree
	 */
	void enterContinueStatement(ShonascriptxParser.ContinueStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShonascriptxParser#continueStatement}.
	 * @param ctx the parse tree
	 */
	void exitContinueStatement(ShonascriptxParser.ContinueStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShonascriptxParser#breakStatement}.
	 * @param ctx the parse tree
	 */
	void enterBreakStatement(ShonascriptxParser.BreakStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShonascriptxParser#breakStatement}.
	 * @param ctx the parse tree
	 */
	void exitBreakStatement(ShonascriptxParser.BreakStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShonascriptxParser#assignable}.
	 * @param ctx the parse tree
	 */
	void enterAssignable(ShonascriptxParser.AssignableContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShonascriptxParser#assignable}.
	 * @param ctx the parse tree
	 */
	void exitAssignable(ShonascriptxParser.AssignableContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShonascriptxParser#assignRoot}.
	 * @param ctx the parse tree
	 */
	void enterAssignRoot(ShonascriptxParser.AssignRootContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShonascriptxParser#assignRoot}.
	 * @param ctx the parse tree
	 */
	void exitAssignRoot(ShonascriptxParser.AssignRootContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShonascriptxParser#memberAccess}.
	 * @param ctx the parse tree
	 */
	void enterMemberAccess(ShonascriptxParser.MemberAccessContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShonascriptxParser#memberAccess}.
	 * @param ctx the parse tree
	 */
	void exitMemberAccess(ShonascriptxParser.MemberAccessContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShonascriptxParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(ShonascriptxParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShonascriptxParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(ShonascriptxParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShonascriptxParser#nyoraStatement}.
	 * @param ctx the parse tree
	 */
	void enterNyoraStatement(ShonascriptxParser.NyoraStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShonascriptxParser#nyoraStatement}.
	 * @param ctx the parse tree
	 */
	void exitNyoraStatement(ShonascriptxParser.NyoraStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShonascriptxParser#arrayAdd}.
	 * @param ctx the parse tree
	 */
	void enterArrayAdd(ShonascriptxParser.ArrayAddContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShonascriptxParser#arrayAdd}.
	 * @param ctx the parse tree
	 */
	void exitArrayAdd(ShonascriptxParser.ArrayAddContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShonascriptxParser#arrayRemove}.
	 * @param ctx the parse tree
	 */
	void enterArrayRemove(ShonascriptxParser.ArrayRemoveContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShonascriptxParser#arrayRemove}.
	 * @param ctx the parse tree
	 */
	void exitArrayRemove(ShonascriptxParser.ArrayRemoveContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShonascriptxParser#conditionalStatement}.
	 * @param ctx the parse tree
	 */
	void enterConditionalStatement(ShonascriptxParser.ConditionalStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShonascriptxParser#conditionalStatement}.
	 * @param ctx the parse tree
	 */
	void exitConditionalStatement(ShonascriptxParser.ConditionalStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShonascriptxParser#functionDefinition}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDefinition(ShonascriptxParser.FunctionDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShonascriptxParser#functionDefinition}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDefinition(ShonascriptxParser.FunctionDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShonascriptxParser#anonymousFunction}.
	 * @param ctx the parse tree
	 */
	void enterAnonymousFunction(ShonascriptxParser.AnonymousFunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShonascriptxParser#anonymousFunction}.
	 * @param ctx the parse tree
	 */
	void exitAnonymousFunction(ShonascriptxParser.AnonymousFunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShonascriptxParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void enterReturnStatement(ShonascriptxParser.ReturnStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShonascriptxParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void exitReturnStatement(ShonascriptxParser.ReturnStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code singleLineSuite}
	 * labeled alternative in {@link ShonascriptxParser#suite}.
	 * @param ctx the parse tree
	 */
	void enterSingleLineSuite(ShonascriptxParser.SingleLineSuiteContext ctx);
	/**
	 * Exit a parse tree produced by the {@code singleLineSuite}
	 * labeled alternative in {@link ShonascriptxParser#suite}.
	 * @param ctx the parse tree
	 */
	void exitSingleLineSuite(ShonascriptxParser.SingleLineSuiteContext ctx);
	/**
	 * Enter a parse tree produced by the {@code blockSuite}
	 * labeled alternative in {@link ShonascriptxParser#suite}.
	 * @param ctx the parse tree
	 */
	void enterBlockSuite(ShonascriptxParser.BlockSuiteContext ctx);
	/**
	 * Exit a parse tree produced by the {@code blockSuite}
	 * labeled alternative in {@link ShonascriptxParser#suite}.
	 * @param ctx the parse tree
	 */
	void exitBlockSuite(ShonascriptxParser.BlockSuiteContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShonascriptxParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(ShonascriptxParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShonascriptxParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(ShonascriptxParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShonascriptxParser#conditionalExpression}.
	 * @param ctx the parse tree
	 */
	void enterConditionalExpression(ShonascriptxParser.ConditionalExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShonascriptxParser#conditionalExpression}.
	 * @param ctx the parse tree
	 */
	void exitConditionalExpression(ShonascriptxParser.ConditionalExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShonascriptxParser#logicalOrExpression}.
	 * @param ctx the parse tree
	 */
	void enterLogicalOrExpression(ShonascriptxParser.LogicalOrExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShonascriptxParser#logicalOrExpression}.
	 * @param ctx the parse tree
	 */
	void exitLogicalOrExpression(ShonascriptxParser.LogicalOrExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShonascriptxParser#logicalAndExpression}.
	 * @param ctx the parse tree
	 */
	void enterLogicalAndExpression(ShonascriptxParser.LogicalAndExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShonascriptxParser#logicalAndExpression}.
	 * @param ctx the parse tree
	 */
	void exitLogicalAndExpression(ShonascriptxParser.LogicalAndExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShonascriptxParser#equalityExpression}.
	 * @param ctx the parse tree
	 */
	void enterEqualityExpression(ShonascriptxParser.EqualityExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShonascriptxParser#equalityExpression}.
	 * @param ctx the parse tree
	 */
	void exitEqualityExpression(ShonascriptxParser.EqualityExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShonascriptxParser#comparisonExpression}.
	 * @param ctx the parse tree
	 */
	void enterComparisonExpression(ShonascriptxParser.ComparisonExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShonascriptxParser#comparisonExpression}.
	 * @param ctx the parse tree
	 */
	void exitComparisonExpression(ShonascriptxParser.ComparisonExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShonascriptxParser#additiveExpression}.
	 * @param ctx the parse tree
	 */
	void enterAdditiveExpression(ShonascriptxParser.AdditiveExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShonascriptxParser#additiveExpression}.
	 * @param ctx the parse tree
	 */
	void exitAdditiveExpression(ShonascriptxParser.AdditiveExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShonascriptxParser#multiplicativeExpression}.
	 * @param ctx the parse tree
	 */
	void enterMultiplicativeExpression(ShonascriptxParser.MultiplicativeExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShonascriptxParser#multiplicativeExpression}.
	 * @param ctx the parse tree
	 */
	void exitMultiplicativeExpression(ShonascriptxParser.MultiplicativeExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShonascriptxParser#powerExpression}.
	 * @param ctx the parse tree
	 */
	void enterPowerExpression(ShonascriptxParser.PowerExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShonascriptxParser#powerExpression}.
	 * @param ctx the parse tree
	 */
	void exitPowerExpression(ShonascriptxParser.PowerExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code unaryOp}
	 * labeled alternative in {@link ShonascriptxParser#unaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterUnaryOp(ShonascriptxParser.UnaryOpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code unaryOp}
	 * labeled alternative in {@link ShonascriptxParser#unaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitUnaryOp(ShonascriptxParser.UnaryOpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code primaryExpr}
	 * labeled alternative in {@link ShonascriptxParser#unaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryExpr(ShonascriptxParser.PrimaryExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code primaryExpr}
	 * labeled alternative in {@link ShonascriptxParser#unaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryExpr(ShonascriptxParser.PrimaryExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code varToSetExpr}
	 * labeled alternative in {@link ShonascriptxParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterVarToSetExpr(ShonascriptxParser.VarToSetExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code varToSetExpr}
	 * labeled alternative in {@link ShonascriptxParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitVarToSetExpr(ShonascriptxParser.VarToSetExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parens}
	 * labeled alternative in {@link ShonascriptxParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterParens(ShonascriptxParser.ParensContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parens}
	 * labeled alternative in {@link ShonascriptxParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitParens(ShonascriptxParser.ParensContext ctx);
	/**
	 * Enter a parse tree produced by the {@code anonymousFunctionExpr}
	 * labeled alternative in {@link ShonascriptxParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterAnonymousFunctionExpr(ShonascriptxParser.AnonymousFunctionExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code anonymousFunctionExpr}
	 * labeled alternative in {@link ShonascriptxParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitAnonymousFunctionExpr(ShonascriptxParser.AnonymousFunctionExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code string}
	 * labeled alternative in {@link ShonascriptxParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterString(ShonascriptxParser.StringContext ctx);
	/**
	 * Exit a parse tree produced by the {@code string}
	 * labeled alternative in {@link ShonascriptxParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitString(ShonascriptxParser.StringContext ctx);
	/**
	 * Enter a parse tree produced by the {@code nounClassExistence}
	 * labeled alternative in {@link ShonascriptxParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterNounClassExistence(ShonascriptxParser.NounClassExistenceContext ctx);
	/**
	 * Exit a parse tree produced by the {@code nounClassExistence}
	 * labeled alternative in {@link ShonascriptxParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitNounClassExistence(ShonascriptxParser.NounClassExistenceContext ctx);
	/**
	 * Enter a parse tree produced by the {@code arrayLiteral}
	 * labeled alternative in {@link ShonascriptxParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterArrayLiteral(ShonascriptxParser.ArrayLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code arrayLiteral}
	 * labeled alternative in {@link ShonascriptxParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitArrayLiteral(ShonascriptxParser.ArrayLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code indexOp}
	 * labeled alternative in {@link ShonascriptxParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterIndexOp(ShonascriptxParser.IndexOpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code indexOp}
	 * labeled alternative in {@link ShonascriptxParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitIndexOp(ShonascriptxParser.IndexOpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code inStringOp}
	 * labeled alternative in {@link ShonascriptxParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterInStringOp(ShonascriptxParser.InStringOpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code inStringOp}
	 * labeled alternative in {@link ShonascriptxParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitInStringOp(ShonascriptxParser.InStringOpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code propertyAccess}
	 * labeled alternative in {@link ShonascriptxParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterPropertyAccess(ShonascriptxParser.PropertyAccessContext ctx);
	/**
	 * Exit a parse tree produced by the {@code propertyAccess}
	 * labeled alternative in {@link ShonascriptxParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitPropertyAccess(ShonascriptxParser.PropertyAccessContext ctx);
	/**
	 * Enter a parse tree produced by the {@code nounClassInequality}
	 * labeled alternative in {@link ShonascriptxParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterNounClassInequality(ShonascriptxParser.NounClassInequalityContext ctx);
	/**
	 * Exit a parse tree produced by the {@code nounClassInequality}
	 * labeled alternative in {@link ShonascriptxParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitNounClassInequality(ShonascriptxParser.NounClassInequalityContext ctx);
	/**
	 * Enter a parse tree produced by the {@code timeoutExpr}
	 * labeled alternative in {@link ShonascriptxParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterTimeoutExpr(ShonascriptxParser.TimeoutExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code timeoutExpr}
	 * labeled alternative in {@link ShonascriptxParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitTimeoutExpr(ShonascriptxParser.TimeoutExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code bracketAccess}
	 * labeled alternative in {@link ShonascriptxParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterBracketAccess(ShonascriptxParser.BracketAccessContext ctx);
	/**
	 * Exit a parse tree produced by the {@code bracketAccess}
	 * labeled alternative in {@link ShonascriptxParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitBracketAccess(ShonascriptxParser.BracketAccessContext ctx);
	/**
	 * Enter a parse tree produced by the {@code lengthExpr}
	 * labeled alternative in {@link ShonascriptxParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterLengthExpr(ShonascriptxParser.LengthExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code lengthExpr}
	 * labeled alternative in {@link ShonascriptxParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitLengthExpr(ShonascriptxParser.LengthExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code number}
	 * labeled alternative in {@link ShonascriptxParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterNumber(ShonascriptxParser.NumberContext ctx);
	/**
	 * Exit a parse tree produced by the {@code number}
	 * labeled alternative in {@link ShonascriptxParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitNumber(ShonascriptxParser.NumberContext ctx);
	/**
	 * Enter a parse tree produced by the {@code joinExpr}
	 * labeled alternative in {@link ShonascriptxParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterJoinExpr(ShonascriptxParser.JoinExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code joinExpr}
	 * labeled alternative in {@link ShonascriptxParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitJoinExpr(ShonascriptxParser.JoinExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprToSetExpr}
	 * labeled alternative in {@link ShonascriptxParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterExprToSetExpr(ShonascriptxParser.ExprToSetExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprToSetExpr}
	 * labeled alternative in {@link ShonascriptxParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitExprToSetExpr(ShonascriptxParser.ExprToSetExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code naturalEqualityOp}
	 * labeled alternative in {@link ShonascriptxParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterNaturalEqualityOp(ShonascriptxParser.NaturalEqualityOpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code naturalEqualityOp}
	 * labeled alternative in {@link ShonascriptxParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitNaturalEqualityOp(ShonascriptxParser.NaturalEqualityOpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code jsObjLiteral}
	 * labeled alternative in {@link ShonascriptxParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterJsObjLiteral(ShonascriptxParser.JsObjLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code jsObjLiteral}
	 * labeled alternative in {@link ShonascriptxParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitJsObjLiteral(ShonascriptxParser.JsObjLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code arrayRange}
	 * labeled alternative in {@link ShonascriptxParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterArrayRange(ShonascriptxParser.ArrayRangeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code arrayRange}
	 * labeled alternative in {@link ShonascriptxParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitArrayRange(ShonascriptxParser.ArrayRangeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code htmlExpr}
	 * labeled alternative in {@link ShonascriptxParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterHtmlExpr(ShonascriptxParser.HtmlExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code htmlExpr}
	 * labeled alternative in {@link ShonascriptxParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitHtmlExpr(ShonascriptxParser.HtmlExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code objLiteral}
	 * labeled alternative in {@link ShonascriptxParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterObjLiteral(ShonascriptxParser.ObjLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code objLiteral}
	 * labeled alternative in {@link ShonascriptxParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitObjLiteral(ShonascriptxParser.ObjLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code inputExpr}
	 * labeled alternative in {@link ShonascriptxParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterInputExpr(ShonascriptxParser.InputExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code inputExpr}
	 * labeled alternative in {@link ShonascriptxParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitInputExpr(ShonascriptxParser.InputExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code nounClassEquality}
	 * labeled alternative in {@link ShonascriptxParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterNounClassEquality(ShonascriptxParser.NounClassEqualityContext ctx);
	/**
	 * Exit a parse tree produced by the {@code nounClassEquality}
	 * labeled alternative in {@link ShonascriptxParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitNounClassEquality(ShonascriptxParser.NounClassEqualityContext ctx);
	/**
	 * Enter a parse tree produced by the {@code propertyGet}
	 * labeled alternative in {@link ShonascriptxParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterPropertyGet(ShonascriptxParser.PropertyGetContext ctx);
	/**
	 * Exit a parse tree produced by the {@code propertyGet}
	 * labeled alternative in {@link ShonascriptxParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitPropertyGet(ShonascriptxParser.PropertyGetContext ctx);
	/**
	 * Enter a parse tree produced by the {@code dotAccess}
	 * labeled alternative in {@link ShonascriptxParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterDotAccess(ShonascriptxParser.DotAccessContext ctx);
	/**
	 * Exit a parse tree produced by the {@code dotAccess}
	 * labeled alternative in {@link ShonascriptxParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitDotAccess(ShonascriptxParser.DotAccessContext ctx);
	/**
	 * Enter a parse tree produced by the {@code inArrayOp}
	 * labeled alternative in {@link ShonascriptxParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterInArrayOp(ShonascriptxParser.InArrayOpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code inArrayOp}
	 * labeled alternative in {@link ShonascriptxParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitInArrayOp(ShonascriptxParser.InArrayOpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code boolean}
	 * labeled alternative in {@link ShonascriptxParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterBoolean(ShonascriptxParser.BooleanContext ctx);
	/**
	 * Exit a parse tree produced by the {@code boolean}
	 * labeled alternative in {@link ShonascriptxParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitBoolean(ShonascriptxParser.BooleanContext ctx);
	/**
	 * Enter a parse tree produced by the {@code domPropertyGet}
	 * labeled alternative in {@link ShonascriptxParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterDomPropertyGet(ShonascriptxParser.DomPropertyGetContext ctx);
	/**
	 * Exit a parse tree produced by the {@code domPropertyGet}
	 * labeled alternative in {@link ShonascriptxParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitDomPropertyGet(ShonascriptxParser.DomPropertyGetContext ctx);
	/**
	 * Enter a parse tree produced by the {@code functionCall}
	 * labeled alternative in {@link ShonascriptxParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCall(ShonascriptxParser.FunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code functionCall}
	 * labeled alternative in {@link ShonascriptxParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCall(ShonascriptxParser.FunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code fetchExpr}
	 * labeled alternative in {@link ShonascriptxParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterFetchExpr(ShonascriptxParser.FetchExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code fetchExpr}
	 * labeled alternative in {@link ShonascriptxParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitFetchExpr(ShonascriptxParser.FetchExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code variable}
	 * labeled alternative in {@link ShonascriptxParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterVariable(ShonascriptxParser.VariableContext ctx);
	/**
	 * Exit a parse tree produced by the {@code variable}
	 * labeled alternative in {@link ShonascriptxParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitVariable(ShonascriptxParser.VariableContext ctx);
	/**
	 * Enter a parse tree produced by the {@code nounClassNonExistence}
	 * labeled alternative in {@link ShonascriptxParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterNounClassNonExistence(ShonascriptxParser.NounClassNonExistenceContext ctx);
	/**
	 * Exit a parse tree produced by the {@code nounClassNonExistence}
	 * labeled alternative in {@link ShonascriptxParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitNounClassNonExistence(ShonascriptxParser.NounClassNonExistenceContext ctx);
	/**
	 * Enter a parse tree produced by the {@code intervalExpr}
	 * labeled alternative in {@link ShonascriptxParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterIntervalExpr(ShonascriptxParser.IntervalExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code intervalExpr}
	 * labeled alternative in {@link ShonascriptxParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitIntervalExpr(ShonascriptxParser.IntervalExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code setExpr}
	 * labeled alternative in {@link ShonascriptxParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterSetExpr(ShonascriptxParser.SetExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code setExpr}
	 * labeled alternative in {@link ShonascriptxParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitSetExpr(ShonascriptxParser.SetExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code methodCall}
	 * labeled alternative in {@link ShonascriptxParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterMethodCall(ShonascriptxParser.MethodCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code methodCall}
	 * labeled alternative in {@link ShonascriptxParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitMethodCall(ShonascriptxParser.MethodCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShonascriptxParser#objectLiteral}.
	 * @param ctx the parse tree
	 */
	void enterObjectLiteral(ShonascriptxParser.ObjectLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShonascriptxParser#objectLiteral}.
	 * @param ctx the parse tree
	 */
	void exitObjectLiteral(ShonascriptxParser.ObjectLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShonascriptxParser#jsObjectLiteral}.
	 * @param ctx the parse tree
	 */
	void enterJsObjectLiteral(ShonascriptxParser.JsObjectLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShonascriptxParser#jsObjectLiteral}.
	 * @param ctx the parse tree
	 */
	void exitJsObjectLiteral(ShonascriptxParser.JsObjectLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShonascriptxParser#jsObjectEntries}.
	 * @param ctx the parse tree
	 */
	void enterJsObjectEntries(ShonascriptxParser.JsObjectEntriesContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShonascriptxParser#jsObjectEntries}.
	 * @param ctx the parse tree
	 */
	void exitJsObjectEntries(ShonascriptxParser.JsObjectEntriesContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShonascriptxParser#jsObjectEntry}.
	 * @param ctx the parse tree
	 */
	void enterJsObjectEntry(ShonascriptxParser.JsObjectEntryContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShonascriptxParser#jsObjectEntry}.
	 * @param ctx the parse tree
	 */
	void exitJsObjectEntry(ShonascriptxParser.JsObjectEntryContext ctx);
	/**
	 * Enter a parse tree produced by the {@code fullRange}
	 * labeled alternative in {@link ShonascriptxParser#rangeExpression}.
	 * @param ctx the parse tree
	 */
	void enterFullRange(ShonascriptxParser.FullRangeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code fullRange}
	 * labeled alternative in {@link ShonascriptxParser#rangeExpression}.
	 * @param ctx the parse tree
	 */
	void exitFullRange(ShonascriptxParser.FullRangeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code simpleRange}
	 * labeled alternative in {@link ShonascriptxParser#rangeExpression}.
	 * @param ctx the parse tree
	 */
	void enterSimpleRange(ShonascriptxParser.SimpleRangeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code simpleRange}
	 * labeled alternative in {@link ShonascriptxParser#rangeExpression}.
	 * @param ctx the parse tree
	 */
	void exitSimpleRange(ShonascriptxParser.SimpleRangeContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShonascriptxParser#arrayElements}.
	 * @param ctx the parse tree
	 */
	void enterArrayElements(ShonascriptxParser.ArrayElementsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShonascriptxParser#arrayElements}.
	 * @param ctx the parse tree
	 */
	void exitArrayElements(ShonascriptxParser.ArrayElementsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShonascriptxParser#arrayElement}.
	 * @param ctx the parse tree
	 */
	void enterArrayElement(ShonascriptxParser.ArrayElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShonascriptxParser#arrayElement}.
	 * @param ctx the parse tree
	 */
	void exitArrayElement(ShonascriptxParser.ArrayElementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShonascriptxParser#argumentList}.
	 * @param ctx the parse tree
	 */
	void enterArgumentList(ShonascriptxParser.ArgumentListContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShonascriptxParser#argumentList}.
	 * @param ctx the parse tree
	 */
	void exitArgumentList(ShonascriptxParser.ArgumentListContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShonascriptxParser#parameterList}.
	 * @param ctx the parse tree
	 */
	void enterParameterList(ShonascriptxParser.ParameterListContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShonascriptxParser#parameterList}.
	 * @param ctx the parse tree
	 */
	void exitParameterList(ShonascriptxParser.ParameterListContext ctx);
}