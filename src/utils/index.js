// src/utils/index.js

export const debounce = (func, wait) => {
  let timeout;
  return function executedFunction(...args) {
    const later = () => {
      clearTimeout(timeout);
      func(...args);
    };
    clearTimeout(timeout);
    timeout = setTimeout(later, wait);
  };
};

export const downloadCode = (filename, content) => {
  const blob = new Blob([content], { type: 'text/plain' });
  const url = URL.createObjectURL(blob);
  const a = document.createElement('a');
  a.href = url;
  a.download = filename;
  a.click();
  URL.revokeObjectURL(url);
};

export const copyToClipboard = async (text) => {
  try {
    await navigator.clipboard.writeText(text);
    console.log('Copied to clipboard');
    return true;
  } catch (err) {
    console.error('Failed to copy:', err);
    return false;
  }
};

export const getFileIcon = (fileName) => {
  if (fileName.endsWith('.shonax')) {
    return 'shonax';
  } else if (fileName.endsWith('.shona')) {
    return 'shona';
  }
  return 'file';
};

export const formatConsoleMessage = (message) => {
  return message.args.join(' ');
};

export const getConsoleMessageClass = (method) => {
  switch (method) {
    case 'error': return 'console-error';
    case 'warn': return 'console-warn';
    case 'info': return 'console-info';
    default: return 'console-log';
  }
};