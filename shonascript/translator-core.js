// translator-core.js
// Combine all translator functions here
import { translateShona as translateShonaCore } from './translator-core-node';
import { translateShonax as translateShonaxCore, compileComponent as compileComponentCore } from './translator-core-shonax';

export function translateShona(code, options = {}) {
  return translateShonaCore(code, options);
}

export function translateShonax(code, options = {}) {
  return translateShonaxCore(code, options);
}

export function compileComponent(code, componentName, options = {}) {
  return compileComponentCore(code, componentName, options);
}