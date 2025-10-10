export default class IndentationProcessor {
    process(input) {
        let lines = input.split('\n');

        // Find the index of the first line that isn't just whitespace.
        const firstCodeLineIndex = lines.findIndex(line => line.trim() !== '');

        if (firstCodeLineIndex === -1) {
            return '\n';
        }

        const firstLine = lines[firstCodeLineIndex];
        const baseIndentMatch = firstLine.match(/^[ \t]*/);
        const baseIndent = baseIndentMatch ? baseIndentMatch[0] : '';

        const dedentRegex = new RegExp(`^${baseIndent}`);

        const processedLinesInput = lines
            .slice(firstCodeLineIndex)
            .map(line => line.replace(dedentRegex, ''));

        // ✨ First pass - join lines that are part of incomplete statements
        const joinedLines = [];
        let currentLine = '';
        let bracketDepth = 0;
        let parenDepth = 0;
        let braceDepth = 0;  // ADD THIS for JS objects
        
        for (let i = 0; i < processedLinesInput.length; i++) {
            const line = processedLinesInput[i];
            const trimmed = line.trim();
            
            // Skip empty lines and comments
            if (trimmed === '' || trimmed.startsWith('//')) {
                if (bracketDepth === 0 && parenDepth === 0 && braceDepth === 0) {  // CHECK braceDepth too
                    if (currentLine) {
                        joinedLines.push(currentLine);
                        currentLine = '';
                    }
                    joinedLines.push(line);
                }
                continue;
            }
            
            // Count brackets, parens, and braces
            for (let char of line) {
                if (char === '[') bracketDepth++;
                if (char === ']') bracketDepth--;
                if (char === '(') parenDepth++;
                if (char === ')') parenDepth--;
                if (char === '{') braceDepth++;    // ADD THIS
                if (char === '}') braceDepth--;    // ADD THIS
            }
            
            // If we're inside brackets/parens/braces, accumulate the line
            if (currentLine && (bracketDepth > 0 || parenDepth > 0 || braceDepth > 0)) {  // CHECK braceDepth
                // Add space before the trimmed content
                currentLine += ' ' + trimmed;
            } else if (bracketDepth > 0 || parenDepth > 0 || braceDepth > 0) {  // CHECK braceDepth
                // Start accumulating
                currentLine = line;
            } else {
                // We're not inside brackets/parens/braces
                if (currentLine) {
                    // Finish the accumulated line
                    currentLine += ' ' + trimmed;
                    joinedLines.push(currentLine);
                    currentLine = '';
                } else {
                    // Normal line
                    joinedLines.push(line);
                }
            }
        }
        
        // Don't forget the last line if we were accumulating
        if (currentLine) {
            joinedLines.push(currentLine);
        }

        // Now process indentation on the joined lines
        const processedLines = [];
        const indentStack = [0];
        let previousIndent = 0;
        
        for (let i = 0; i < joinedLines.length; i++) { 
            const line = joinedLines[i];
            const trimmedLine = line.trim();
            
            if (trimmedLine === '' || trimmedLine.startsWith('//')) {
                processedLines.push(line);
                continue;
            }
            
            let currentIndent = 0;
            for (let j = 0; j < line.length; j++) {
                if (line[j] === ' ') {
                    currentIndent++;
                } else if (line[j] === '\t') {
                    currentIndent += 4;
                } else {
                    break;
                }
            }
            
            if (currentIndent > previousIndent) {
                indentStack.push(currentIndent);
                processedLines.push('INDENT');
                processedLines.push(line);
            } else if (currentIndent < previousIndent) {
                while (indentStack.length > 1 && indentStack[indentStack.length - 1] > currentIndent) {
                    indentStack.pop();
                    processedLines.push('DEDENT');
                }
                
                if (indentStack[indentStack.length - 1] !== currentIndent) {
                    throw new Error(`Inconsistent indentation at line ${i + 1}`);
                }
                
                processedLines.push(line);
            } else {
                processedLines.push(line);
            }
            
            previousIndent = currentIndent;
        }
        
        while (indentStack.length > 1) {
            indentStack.pop();
            processedLines.push('DEDENT');
        }

        let out = processedLines.join('\n');
        if (!out.endsWith('\n')) out += '\n';
        return out;
    }
}