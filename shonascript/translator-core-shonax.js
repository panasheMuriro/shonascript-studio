// translator-core-shonax.js
import antlr4 from 'antlr4';
import ShonascriptxLexer from './build/ShonascriptxLexer.js';
import ShonascriptxParser from './build/ShonascriptxParser.js';
import CustomShonascriptxVisitor from './CustomShonascriptxVisitor.js';
import IndentationProcessor from './IndentationProcessor.js';

export function translateShonax(shonaxCode, options = {}) {
    try {
        const processor = new IndentationProcessor();
        const processedCode = processor.process(shonaxCode);
        
        const chars = new antlr4.InputStream(processedCode);
        const lexer = new ShonascriptxLexer(chars);
        const tokens = new antlr4.CommonTokenStream(lexer);
        const parser = new ShonascriptxParser(tokens);
        
        parser.buildParseTrees = true;
        const tree = parser.program();
        
        const visitor = new CustomShonascriptxVisitor(options);
        visitor.parser = parser;
        const jsCode = visitor.visit(tree);
        
        return jsCode;
    } catch (error) {
        console.error('Shonax translation error:', error);
        throw new Error(`Shonax translation error: ${error.message}`);
    }
}

export function compileComponent(shonaxCode, componentName, options = {}) {
    try {
        const processor = new IndentationProcessor();
        const processedCode = processor.process(shonaxCode);
        
        const chars = new antlr4.InputStream(processedCode);
        const lexer = new ShonascriptxLexer(chars);
        const tokens = new antlr4.CommonTokenStream(lexer);
        const parser = new ShonascriptxParser(tokens);
        
        parser.buildParseTrees = true;
        const tree = parser.program();
        
        // Use component mode
        const visitor = new CustomShonascriptxVisitor({ 
            ...options, 
            target: 'component',
            componentName 
        });
        visitor.parser = parser;
        const jsCode = visitor.visit(tree);
        
        return jsCode;
    } catch (error) {
        console.error('Component compilation error:', error);
        throw new Error(`Component compilation error: ${error.message}`);
    }
}