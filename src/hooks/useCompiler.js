// src/hooks/useCompiler.js

import { useState, useEffect, useCallback, useMemo } from 'react';
import { debounce } from '../utils';
import { createScriptHtml, createPreviewHtmlWithImports } from '../utils/htmlGenerators';
import { compileComponent } from '../../shonascript/translator-core-shonax';
import { translateShona } from '../../shonascript/translator-core';

export const useCompiler = (sourceCode, currentFile, files) => {
  const [compiledCode, setCompiledCode] = useState('');
  const [previewHtml, setPreviewHtml] = useState('');
  const [errors, setErrors] = useState([]);
  const [warnings, setWarnings] = useState([]);
  const [isCompiling, setIsCompiling] = useState(false);
  
//   const compiledCacheRef = useRef(new Map());

  const compile = useCallback(async (code, file, allFiles) => {
    if (!file) return;
    
    setIsCompiling(true);
    setErrors([]);
    setWarnings([]);
    
    try {
      const isShonax = file.name.endsWith('.shonax');
      const isShona = file.name.endsWith('.shona');
      
      let jsCode = '';
      let html = '';
      
      if (isShonax) {
        const componentName = file.name.replace(/\.(shonax|shona)$/, '');
        jsCode = compileComponent(code, componentName, {
          target: 'component',
          generateSourceMap: true
        });
        
        html = createPreviewHtmlWithImports(jsCode, allFiles, compileComponent, translateShona);
      } else if (isShona) {
        jsCode = translateShona(code, {
          target: 'browser'
        });
        
        html = createScriptHtml(jsCode, allFiles, code, file, translateShona);
      } else {
        throw new Error('Unsupported file type. Use .shona or .shonax extension.');
      }
      
      setCompiledCode(jsCode);
      setPreviewHtml(html);
      
    } catch (error) {
      console.error('Compilation error:', error);
      setErrors([error.message]);
    } finally {
      setIsCompiling(false);
    }
  }, []);

  const debouncedCompile = useMemo(() => debounce(compile, 500), [compile]);

  useEffect(() => {
    if (currentFile && files.length > 0) {
      debouncedCompile(sourceCode, currentFile, files);
    }
  }, [sourceCode, currentFile, files, debouncedCompile]);

  // REMOVED the broken useEffect that was doing nothing

  return {
    compiledCode,
    previewHtml,
    errors,
    warnings,
    isCompiling
  };
};