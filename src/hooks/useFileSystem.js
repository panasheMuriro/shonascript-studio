// src/hooks/useFileSystem.js

import { useState, useEffect, useCallback } from 'react';

const dedent = (str) => {
    // 1. Remove the first line if it's just a newline from the opening backtick.
    const base = str.startsWith('\n') ? str.slice(1) : str;

    // 2. Find the minimum indentation of all non-empty lines.
    const minIndent = base
        .split('\n')
        .filter(line => line.trim()) // Ignore empty lines
        .reduce((min, line) => {
            const indent = line.match(/^\s*/)[0].length;
            return Math.min(min, indent);
        }, Infinity);

    // If all lines are empty, return an empty string.
    if (minIndent === Infinity) {
        return '';
    }

    // 3. Remove the common indentation from each line.
    const dedented = base
        .split('\n')
        .map(line => line.slice(minIndent))
        .join('\n');

    // 4. Trim any leading/trailing whitespace from the whole block.
    return dedented.trim();
};

const DEFAULT_FILES = [
    {
        type: 'folder',
        name: 'shona-examples',
        path: 'shona-examples',
        expanded: true, // Expanded by default to show the examples
        children: [
            {
                type: 'file',
                name: '01_variables.shona',
                path: 'shona-examples/01_variables.shona',
                content: dedent(`
          """
          --- Ma Variables ---
          """

          // Gadzira variable inonzi 'zita' ugoisa zita rako.
          zita = "Tadiwa"

          // Gadzira variable inonzi 'zera' ugoisa makore ako.
          zera = 25

          // Shandisa 'nyora' kuti uone zviri mukati mevariables.
          nyora "Zita rangu ndi", zita
          nyora "Ndine makore anokwana", zera

          // Unogona kuchinja zviri muvariable chero nguva.
          zera = 26
          nyora "Gore rinotevera ndichange ndava nemakore", zera
        `),
                modified: false
            },
            {
                type: 'file',
                name: '02_datatypes.shona',
                path: 'shona-examples/02_datatypes.shona',
                content: dedent(`
          """
          --- Ma Data Types ---
          """

          // Mhando yeString
          chirevo = "Mhoro, Shonascript!"

          // Mhando yeNumber
          nhamba_yese = 10
          nhamba_yedesimali = 3.14

          // Mhando yeBoolean
          zuva_rabuda = chokwadi
          kuri_kunaya = kwete

          nyora "String:", chirevo
          nyora "Nhamba Yakazara:", nhamba_yese
          nyora "Nhamba Yedesimali:", nhamba_yedesimali
          nyora "Zuva rabuda here?", zuva_rabuda
        `),
                modified: false
            },
            {
                type: 'file',
                name: '03_conditionals.shona',
                path: 'shona-examples/03_conditionals.shona',
                content: dedent(`
          """
          --- Ma Conditionals (Kana Zvikadaro...) ---
          """

          zera = 19

          kana zera >= 18:
              nyora "Munhu mukuru, anogona kuvhota."
          kana kuti zera >= 13:
              nyora "Pwere, haakwanise kuvhota."
          zvimwe:
              nyora "Mwana mudiki."

          // Unogona kuishandisa pasina 'zvimwe'.
          kunze_kuri_kupisa = chokwadi
          kana kunze_kuri_kupisa:
              nyora "Inwa mvura yakawanda!"
        `),
                modified: false
            },
            {
                type: 'file',
                name: '04_loops.shona',
                path: 'shona-examples/04_loops.shona',
                content: dedent(`
          """
          --- Ma Loops (Kudzokorora) ---
          """

          nyora "--- Loop Yese ---"
          mazita = ["Ana", "Tino", "Chipo"]
          pane zita mu mazita:
              nyora "Mhoro,", zita

          nyora "\\n--- Loop ine 'jamba' (skip) ---"
          pane nhamba mu [1, 2, 3, 4, 5]:
              kana nhamba == 3:
                  nyora "(Tasvetuka 3)"
                  jamba
              nyora "Tiri pa nhamba:", nhamba

          nyora "\\n--- Loop ine 'mira' (stop) ---"
          pane x mu [1, 2, 3, 4, 5]:
              kana x == 4:
                  nyora "(Tamira tisati tasvika pa 4)"
                  mira
              nyora "Tiri pa nhamba:", x
        `),
                modified: false
            },
            {
                type: 'file',
                name: '05_functions.shona',
                path: 'shona-examples/05_functions.shona',
                content: dedent(`
          """
          --- Ma Functions (Mabasa) ---
          """

          // Basa risingadzose chinhu.
          basa kwazisa(zita):
              nyora "Mhoro,", zita

          // Basa rinodzosa mhinduro.
          basa wedzera(a, b):
              dzosa a + b

          // Kushandisa mabasa
          kwazisa("Shamwari")
          kwazisa("Vatengi")

          chitsama = wedzera(5, 3)
          nyora "Mhinduro ya 5 + 3 ndi", chitsama
        `),
                modified: false
            },
            {
                type: 'file',
                name: '06_arrays.shona',
                path: 'shona-examples/06_arrays.shona',
                content: dedent(`
          """
          --- Ma Arrays (Zvinhu zvakwanda) ---
          """

          midziyo = ["banga", "forogo", "chipunu"]
          nyora "Midziyo:", midziyo

          hurefu_hwe_array = verenga midziyo
          nyora "Tine midziyo:", hurefu_hwe_array

          // Tora chinhu chechipiri.
          chechipiri = pa 2 mu midziyo
          nyora "Chinhu chechipiri ndi:", chechipiri

          // Wedzera chinhu chitsva.
          isa "kapu" mu midziyo
          nyora "Tawedzera 'kapu':", midziyo
        `),
                modified: false
            },
            {
                type: 'file',
                name: '07_objects.shona',
                path: 'shona-examples/07_objects.shona',
                content: dedent(`
          """
          --- Ma Objects ---
          """

          // Gadzira object inonzi 'motokari'
          motokari ane:
              mhando = "Toyota"
              gore = 2022
              ruvara = "dema"

          // Tora mashoko kubva mu-object.
          nyora "Mota iyi imhando ye", mhando ye motokari
          nyora "Yakagadzirwa mugore ra", gore re motokari
        `),
                modified: false
            },
            {
                type: 'file',
                name: '08_comments.shona',
                path: 'shona-examples/08_comments.shona',
                content: dedent(`
          """
          --- Ma Comments (Tsananguro muCode) ---
          """

          // 1. Single-line comment.
          // Inotanga na // uye inoperera pamutsetse iwoyo.

          /*
             2. Multi-line comment (C-style).
             Inogona kutora mitsara yakawanda.
          */

          """
             3. Multi-line comment (Python-style).
             Inoshandisa triple-quotes. Inoshanda zvakafanana
             ne C-style.
          """

          nyora "Mashoko aya achaonekwa, asi macomments haaonekwe."
        `),
                modified: false
            }
        ]
    },
    {
        type: 'folder',
        name: 'shonax-examples',
        path: 'shonax-examples',
        expanded: false, // Collapsed by default
        children: [
            {
                type: 'file',
                name: 'hello_world.shonax',
                path: 'shonax-examples/01_hello_world.shonax',
                content: dedent(`
          """
          --- Your First Shonax Component ---

          Shonax inosanganisa Shonascript neHTML.
          Unogona kunyora HTML zvakananga mufaira rako.
          Uchishandisa {} unogona kuisa ma-variables mukati meHTML.
          """

          zita = "Zimbabwe"

          <div>
              <h1>Hesi from {zita}!</h1>
              <p>Welcome to Shonax components.</p>
          </div>
        `),
                modified: false
            },
            {
                type: 'file',
                name: 'counter.shonax',
                path: 'shonax-examples/02_counter.shonax',
                content: dedent(`
          """
--- Interactive Components ---
"""

count = 0

basa wedzera1():
    count++

basa bvisa1():
    count--

<div>
    <h1>Counter</h1>
    <p>Count yave pa: {count}</p>
    <button class="bg-green-600 text-white p-2" rikabayiwa={wedzera1}>Wedzera</button>
    <button class="bg-red-600 text-white p-2"  rikabayiwa={bvisa1}>Bvisa</button>
</div>
        `),
                modified: false
            }
        ]
    }
];
const findItemInTree = (items, path) => {
    for (const item of items) {
        if (item.path === path) return item;
        if (item.type === 'folder' && item.children) {
            const found = findItemInTree(item.children, path);
            if (found) return found;
        }
    }
    return null;
};

// Helper function to update item in nested structure
const updateItemInTree = (items, path, updater) => {
    return items.map(item => {
        if (item.path === path) {
            return updater(item);
        }
        if (item.type === 'folder' && item.children) {
            return {
                ...item,
                children: updateItemInTree(item.children, path, updater)
            };
        }
        return item;
    });
};

// Helper function to remove item from tree
const removeFromTree = (items, path) => {
    return items.filter(item => {
        if (item.path === path) return false;
        if (item.type === 'folder' && item.children) {
            item.children = removeFromTree(item.children, path);
        }
        return true;
    });
};

// Helper function to add item to folder
const addToFolder = (items, folderPath, newItem) => {
    return items.map(item => {
        if (item.path === folderPath && item.type === 'folder') {
            return {
                ...item,
                children: [...(item.children || []), newItem],
                expanded: true
            };
        }
        if (item.type === 'folder' && item.children) {
            return {
                ...item,
                children: addToFolder(item.children, folderPath, newItem)
            };
        }
        return item;
    });
};

// Helper to flatten file tree for tabs
const flattenFileTree = (items, result = []) => {
    for (const item of items) {
        if (item.type === 'file') {
            result.push(item);
        }
        if (item.type === 'folder' && item.children) {
            flattenFileTree(item.children, result);
        }
    }
    return result;
};

// Save and load file tree from localStorage
const saveFileTree = (tree) => {
    // localStorage.setItem('shonax_file_tree', JSON.stringify(tree));
};

const loadFileTree = () => {
    // const saved = localStorage.getItem('shonax_file_tree');
    // if (saved) {
    //     try {
    //         return JSON.parse(saved);
    //     } catch (e) {
    //         console.error('Failed to parse saved file tree:', e);
    //     }
    // }
    // return null;
};

// Save individual file content
const saveFileContent = (path, content) => {
    // localStorage.setItem(`shonax_file_content_${path}`, content);
};

const loadFileContent = (path) => {
    // return localStorage.getItem(`shonax_file_content_${path}`);
};

export const useFileSystem = () => {
    const [fileTree, setFileTree] = useState([]);
    const [currentFile, setCurrentFile] = useState(null);
    const [openTabs, setOpenTabs] = useState([]);
    const [code, setCode] = useState('');
    const [filesInitialized, setFilesInitialized] = useState(false);
    const [expandedFolders, setExpandedFolders] = useState(new Set());

    // Initialize file system
    useEffect(() => {
        if (filesInitialized) return;

        // Try to load saved file tree
        const savedTree = loadFileTree();
        let treeToUse = savedTree || DEFAULT_FILES;

        // Load content for all files
        const loadContent = (items) => {
            return items.map(item => {
                if (item.type === 'file') {
                    const savedContent = loadFileContent(item.path);
                    if (savedContent !== null) {
                        return { ...item, content: savedContent };
                    }
                }
                if (item.type === 'folder' && item.children) {
                    return { ...item, children: loadContent(item.children) };
                }
                return item;
            });
        };

        treeToUse = loadContent(treeToUse);
        setFileTree(treeToUse);

        // Initialize expanded folders
        const expanded = new Set();
        const collectExpanded = (items) => {
            items.forEach(item => {
                if (item.type === 'folder' && item.expanded) {
                    expanded.add(item.path);
                }
                if (item.children) collectExpanded(item.children);
            });
        };
        collectExpanded(treeToUse);
        setExpandedFolders(expanded);

        // Select first file
        const allFiles = flattenFileTree(treeToUse);
        if (allFiles.length > 0) {
            const firstFile = allFiles[0];
            setCurrentFile(firstFile);
            setCode(firstFile.content || '');
            setOpenTabs([firstFile]);
        }

        setFilesInitialized(true);
    }, [filesInitialized]);

    // Toggle folder expansion
    const toggleFolder = useCallback((folderPath) => {
        setExpandedFolders(prev => {
            const next = new Set(prev);
            if (next.has(folderPath)) {
                next.delete(folderPath);
            } else {
                next.add(folderPath);
            }

            // Update the tree to persist expansion state
            setFileTree(prevTree =>
                updateItemInTree(prevTree, folderPath, folder => ({
                    ...folder,
                    expanded: !folder.expanded
                }))
            );

            return next;
        });
    }, []);

    // Select file
    const handleFileSelect = useCallback((file) => {
        if (!file || file.type !== 'file') return;

        // Save current file if modified
        if (currentFile && currentFile.modified) {
            saveFileContent(currentFile.path, code);
            setFileTree(prev =>
                updateItemInTree(prev, currentFile.path, f => ({
                    ...f,
                    content: code,
                    modified: false
                }))
            );
        }

        setCurrentFile(file);
        setCode(file.content || '');

        // Add to tabs if not open
        if (!openTabs.find(tab => tab.path === file.path)) {
            setOpenTabs(prev => [...prev, file]);
        }
    }, [currentFile, code, openTabs]);

    // Create folder
    const handleFolderCreate = useCallback((parentPath, folderName) => {
        const newPath = parentPath ? `${parentPath}/${folderName}` : folderName;

        // Check if already exists
        if (findItemInTree(fileTree, newPath)) {
            console.warn(`Folder ${newPath} already exists`);
            return;
        }

        const newFolder = {
            type: 'folder',
            name: folderName,
            path: newPath,
            children: [],
            expanded: true
        };

        if (parentPath) {
            setFileTree(prev => {
                const updated = addToFolder(prev, parentPath, newFolder);
                saveFileTree(updated);
                return updated;
            });
        } else {
            setFileTree(prev => {
                const updated = [...prev, newFolder];
                saveFileTree(updated);
                return updated;
            });
        }

        setExpandedFolders(prev => new Set([...prev, newPath]));
    }, [fileTree]);

    // Create file
    const handleFileCreate = useCallback((path, content = '') => {
        let fileName, parentPath;

        if (path.includes('/')) {
            const parts = path.split('/');
            fileName = parts.pop();
            parentPath = parts.join('/');
        } else {
            fileName = path;
            parentPath = null;
        }

        // Generate unique name if exists
        let finalPath = path;
        let finalName = fileName;
        if (findItemInTree(fileTree, finalPath)) {
            const timestamp = Date.now();
            const extension = fileName.includes('.') ? fileName.split('.').pop() : 'shonax';
            const baseName = fileName.includes('.') ? fileName.split('.').slice(0, -1).join('.') : fileName;
            finalName = `${baseName}-${timestamp}.${extension}`;
            finalPath = parentPath ? `${parentPath}/${finalName}` : finalName;
        }

        // Default content based on extension
        let defaultContent = content;
        if (!content) {
            if (finalName.endsWith('.shonax')) {
                defaultContent = `// New Shonax Component\n\n<div>\n    <h1>Hello World</h1>\n</div>`;
            } else if (finalName.endsWith('.shona')) {
                defaultContent = `// New Shona Script\n\nnyora "Hello World!"`;
            }
        }

        const newFile = {
            type: 'file',
            name: finalName,
            path: finalPath,
            content: defaultContent,
            modified: false
        };

        if (parentPath) {
            setFileTree(prev => {
                const updated = addToFolder(prev, parentPath, newFile);
                saveFileTree(updated);
                return updated;
            });
        } else {
            setFileTree(prev => {
                const updated = [...prev, newFile];
                saveFileTree(updated);
                return updated;
            });
        }

        saveFileContent(finalPath, defaultContent);
        handleFileSelect(newFile);
    }, [fileTree, handleFileSelect]);

    // Delete file or folder
    const handleDelete = useCallback((path) => {
        const item = findItemInTree(fileTree, path);
        if (!item) return;

        const confirmMessage = item.type === 'folder'
            ? `Are you sure you want to delete the folder "${item.name}" and all its contents?`
            : `Are you sure you want to delete "${item.name}"?`;

        if (!window.confirm(confirmMessage)) return;

        // Remove from localStorage
        const removeContent = (itemToRemove) => {
            if (itemToRemove.type === 'file') {
                localStorage.removeItem(`shonax_file_content_${itemToRemove.path}`);
            } else if (itemToRemove.type === 'folder' && itemToRemove.children) {
                itemToRemove.children.forEach(removeContent);
            }
        };
        removeContent(item);

        // Remove from tree
        setFileTree(prev => {
            const updated = removeFromTree(prev, path);
            saveFileTree(updated);
            return updated;
        });

        // Close tabs if needed
        if (item.type === 'file') {
            setOpenTabs(prev => prev.filter(t => t.path !== path));
            if (currentFile?.path === path) {
                const allFiles = flattenFileTree(fileTree);
                const remainingFile = allFiles.find(f => f.path !== path);
                if (remainingFile) {
                    handleFileSelect(remainingFile);
                } else {
                    setCurrentFile(null);
                    setCode('');
                }
            }
        } else {
            // Remove tabs for all files in deleted folder
            const filesInFolder = flattenFileTree([item]);
            setOpenTabs(prev => prev.filter(t => !filesInFolder.some(f => f.path === t.path)));
            if (filesInFolder.some(f => f.path === currentFile?.path)) {
                setCurrentFile(null);
                setCode('');
            }
        }
    }, [fileTree, currentFile, handleFileSelect]);

    // Rename file or folder
    const handleRename = useCallback((oldPath, newName) => {
        const item = findItemInTree(fileTree, oldPath);
        if (!item) return;

        const pathParts = oldPath.split('/');
        pathParts[pathParts.length - 1] = newName;
        const newPath = pathParts.join('/');

        // Update content in localStorage
        if (item.type === 'file') {
            const content = loadFileContent(oldPath);
            localStorage.removeItem(`shonax_file_content_${oldPath}`);
            saveFileContent(newPath, content);
        }

        // Update tree
        setFileTree(prev =>
            updateItemInTree(prev, oldPath, i => ({
                ...i,
                name: newName,
                path: newPath
            }))
        );

        // Update open tabs
        setOpenTabs(prev => prev.map(tab =>
            tab.path === oldPath ? { ...tab, name: newName, path: newPath } : tab
        ));

        // Update current file
        if (currentFile?.path === oldPath) {
            setCurrentFile(prev => ({ ...prev, name: newName, path: newPath }));
        }

        saveFileTree(fileTree);
    }, [fileTree, currentFile]);

    // Update current code
    const updateCurrentCode = useCallback((newCode) => {
        setCode(newCode);

        if (currentFile && newCode !== currentFile.content) {
            setFileTree(prev =>
                updateItemInTree(prev, currentFile.path, f => ({
                    ...f,
                    modified: true
                }))
            );

            setOpenTabs(prev => prev.map(tab =>
                tab.path === currentFile.path ? { ...tab, modified: true } : tab
            ));
        }
    }, [currentFile]);

    // Save current file
    const handleSaveFile = useCallback(() => {
        if (!currentFile || !currentFile.modified) return;

        saveFileContent(currentFile.path, code);

        setFileTree(prev =>
            updateItemInTree(prev, currentFile.path, f => ({
                ...f,
                content: code,
                modified: false
            }))
        );

        setOpenTabs(prev => prev.map(tab =>
            tab.path === currentFile.path
                ? { ...tab, content: code, modified: false }
                : tab
        ));

        setCurrentFile(prev => ({ ...prev, content: code, modified: false }));

        saveFileTree(fileTree);
        console.log(`Saved ${currentFile.name}`);
    }, [currentFile, code, fileTree]);

    // Close tab
    const handleCloseTab = useCallback((tab) => {
        if (tab.modified) {
            const save = window.confirm(`Save changes to ${tab.name}?`);
            if (save) {
                handleSaveFile();
            }
        }

        const newTabs = openTabs.filter(t => t.path !== tab.path);
        setOpenTabs(newTabs);

        if (currentFile?.path === tab.path && newTabs.length > 0) {
            handleFileSelect(newTabs[newTabs.length - 1]);
        } else if (newTabs.length === 0) {
            setCurrentFile(null);
            setCode('');
        }
    }, [openTabs, currentFile, handleFileSelect, handleSaveFile]);

    // Get flattened list of all files
    const getAllFiles = useCallback(() => {
        return flattenFileTree(fileTree);
    }, [fileTree]);

    return {
        fileTree,
        currentFile,
        openTabs,
        code,
        expandedFolders,
        filesInitialized,

        // Actions
        setCode: updateCurrentCode,
        handleFileSelect,
        handleFolderCreate,
        handleFileCreate,
        handleDelete,
        handleRename,
        handleSaveFile,
        handleCloseTab,
        toggleFolder,
        getAllFiles,

        // For compatibility
        files: getAllFiles(),
        handleFileDelete: handleDelete,
        handleFileRename: handleRename,
        updateFileContent: () => { }, // Deprecated
        setFiles: () => { }, // Deprecated
        setOpenTabs: () => { } // Deprecated
    };
};