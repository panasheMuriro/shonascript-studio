import antlr4 from 'antlr4'; // <-- Node.js version
import IndentationProcessor from './IndentationProcessor';
import ShonascriptxLexer from './build/ShonascriptxLexer';
import ShonascriptxParser from './build/ShonascriptxParser';
import CustomShonascriptxVisitor from './CustomShonascriptxVisitor';

export function translateShona(shonascriptCode, options = {}) {
    try { const { target = 'browser' } = options;
        const processor = new IndentationProcessor();
        const processedCode = processor.process(shonascriptCode);
        const chars = new antlr4.InputStream(processedCode);
        const lexer = new ShonascriptxLexer(chars);
        const tokens = new antlr4.CommonTokenStream(lexer);
        const parser = new ShonascriptxParser(tokens);
        parser.buildParseTrees = true;
        const tree = parser.program();
        const visitor = new CustomShonascriptxVisitor({target: target});
        const jsCode = visitor.visit(tree);
        return jsCode;
    } catch (error) {
        console.error('Translation error:', error);
        throw new Error(`Shonascript translation error: ${error.message}`);
    }
}